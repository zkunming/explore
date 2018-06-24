package com.netease.explore.zookeeper;

import com.netease.explore.core.util.Printer;
import com.netease.explore.zookeeper.common.ZookeeperConstant;
import com.netease.explore.zookeeper.dto.Dubbo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
public class CuratorExample
{
	public static void main(String[] args) throws Exception
	{
		//===========Curator的使用[可以直接查curator官方的example项目]===========

		//1、注册监听
		watchExample();
		//2、分布式锁
		lockExample();
		//3、leader选举
		leaderExample();
		//4、扩展包[实现服务发现路--可以查看example]

		//[主线程无限等待、泡杯茶呗]
		CountDownLatch countDownLatch = new CountDownLatch(1);
		countDownLatch.await();
	}

	/**
	 * 对节点进行监听
	 */
	public static void watchExample() throws Exception
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient(ZookeeperConstant.CONNECT_STRING,
				new RetryNTimes(ZookeeperConstant.RETRY_TIME, ZookeeperConstant.SESSION_TIMEOUT));
		client.start();

		//1、实现对当前节点的监控【类似的，可以将NodeCache改为PathChildrenCache，实现对子节点的监控】
		final NodeCache nodeCache = new NodeCache(client, ZookeeperConstant.PATH, false);
		nodeCache.getListenable().addListener(new NodeCacheListener()
		{
			@Override
			public void nodeChanged() throws InterruptedException
			{
				Printer.testPrint(nodeCache.getCurrentData());
				Printer.testPrint(new String(nodeCache.getCurrentData().getData()));
				TimeUnit.SECONDS.sleep(2);
			}
		});
		//2、如果为true则首次不会缓存节点内容到cache中，默认为false,设置为true首次不会触发监听事件
		nodeCache.start();
	}

	/**
	 * 1、发布订阅
	 */
	@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
	private static void pubSubExample()
	{
		//1、订阅者线程
		//noinspection AlibabaAvoidManuallyCreateThread
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				CuratorFramework client = CuratorFrameworkFactory.newClient(ZookeeperConstant.CONNECT_STRING,
						new RetryNTimes(ZookeeperConstant.RETRY_TIME, ZookeeperConstant.SESSION_TIMEOUT));

				client.start();
				ServiceDiscovery<Dubbo> serviceDiscovery = ServiceDiscoveryBuilder.builder(Dubbo.class).client(client).
						basePath(ZookeeperConstant.DUBBO_SERVICE_PATH).serializer(null).build();

				try
				{
					serviceDiscovery.start();
					System.out.println("发现了吗？");
				}
				catch (Exception e)
				{
					throw new RuntimeException(e);
				}
			}
		}, "订阅者").start();

		//2、发布者线程
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{

			}
		}, "发布者").start();
	}

	/**
	 * 2、分布式锁
	 */
	private static void leaderExample()
	{

		int nThreads = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		final AtomicInteger count = new AtomicInteger();

		for (int i = 0; i < nThreads; i++)
		{
			executorService.submit(new Callable<Object>()
			{
				@Override
				public Object call() throws Exception
				{
					CuratorFramework client = CuratorFrameworkFactory.newClient(ZookeeperConstant.CONNECT_STRING,
							new RetryNTimes(ZookeeperConstant.RETRY_TIME, ZookeeperConstant.SESSION_TIMEOUT));

					client.start();

					LeaderSelector leaderSelector = new LeaderSelector(client, ZookeeperConstant.LEADER_SELECTOR_PATH,
							new LeaderSelectorListenerAdapter()
							{
								@Override
								public void takeLeadership(CuratorFramework client) throws Exception
								{
									int num = count.addAndGet(1);
									System.out.println("I am leader.....:" + num);
									//之所以用这个，是要模拟当前节点如果挂了，其他节点是否能补充进来
									Thread.currentThread().interrupt();
								}
							});

					leaderSelector.start();
					return null;
				}
			});
		}
	}

	/**
	 * 3、最基本的排斥锁的使用【还有其他锁也能实现，读写锁~~】
	 */
	public static void lockExample()
	{

		int nThreads = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		final AtomicInteger count = new AtomicInteger();

		for (int i = 0; i < nThreads; i++)
		{
			executorService.submit(new Callable<Object>()
			{
				@Override
				public Object call() throws Exception
				{
					CuratorFramework client = CuratorFrameworkFactory.newClient(ZookeeperConstant.CONNECT_STRING,
							new RetryNTimes(ZookeeperConstant.RETRY_TIME, ZookeeperConstant.SESSION_TIMEOUT));

					client.start();

					InterProcessMutex lock = new InterProcessMutex(client, ZookeeperConstant.LOCK_PATH);
					lock.acquire();
					try
					{
						System.out.println(Thread.currentThread().getName() + "线程 :拿到锁了！");
						System.out.println("可以打开门，回家咯");
					}
					finally
					{
						System.out.println("释放次数:" + count.addAndGet(1));
						lock.release();
					}
					return null;
				}
			});
		}

	}

}
