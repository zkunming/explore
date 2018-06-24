package com.netease.explore.zookeeper;

import com.google.common.collect.Lists;
import com.netease.explore.zookeeper.common.ZookeeperConstant;
import com.netease.explore.zookeeper.util.ZookeeperUtil;
import com.netease.explore.zookeeper.watcher.DubboServiceWatcher;
import com.netease.explore.zookeeper.watcher.ZooKeeperWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

public class ZKDeepExample
{

	/**
	 * 思考：关于path设置监听器，其实
	 */
	public static void main(String[] args) throws Exception
	{
		//1、初始化ZK
		final ZooKeeper zooKeeper = buildZookeeperWithDigest();

		//2、节点的了解 [X]、节点的监听[X]、节点的ACL[X]、集群扩容，容灾、zookeeper的实现原理、
		ZKOperation zkOperation = new ZKOperation(zooKeeper, ZookeeperConstant.PATH);
		zkOperation.execute();
		//3、主线程等待
		CountDownLatch countDownLatch = new CountDownLatch(1);
		countDownLatch.await();
	}

	/**
	 * 实验阶段的zookeeper
	 */
	public static class ZKOperation
	{
		private ZooKeeper zooKeeper;
		private String path;
		private DubboServiceWatcher dubboServiceWatcher;
		private ACL aclDigest;

		public ZKOperation(ZooKeeper zooKeeper, String path) throws NoSuchAlgorithmException
		{
			this.zooKeeper = zooKeeper;
			this.path = path;
			this.dubboServiceWatcher = new DubboServiceWatcher(zooKeeper);
			aclDigest = new ACL(ZooDefs.Perms.READ | ZooDefs.Perms.WRITE, new Id(ZookeeperConstant.SCHEME,
					DigestAuthenticationProvider.generateDigest(ZookeeperConstant.AUTH)));
		}

		public void execute()
		{
			try
			{

				Stat stat1 = new Stat();
				zooKeeper.getData(path, dubboServiceWatcher, stat1);

				//1、无限监听模式【虽然是无限监听，但是不能及时监听到】
				Stat stat = zooKeeper.exists(path, dubboServiceWatcher);

				//2、如果为空，那么说明该节点没有被创建过
				if (stat != null)
				{
					ZookeeperUtil.getAndPrintData(path, zooKeeper);
					ZookeeperUtil.deleteByRecurrence(path, zooKeeper);
				}
				//3、创建需要密码才能访问的节点
				zooKeeper.create(path, "持久节点".getBytes(), Lists.newArrayList(aclDigest), CreateMode.PERSISTENT);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	/**
	 * 创建zookeeper
	 */
	public static ZooKeeper buildZookeeperWithDigest() throws IOException
	{
		ZooKeeper zooKeeper = null;

		//1、初始化启动参数
		zooKeeper = new ZooKeeper(ZookeeperConstant.CONNECT_STRING, ZookeeperConstant.SESSION_TIMEOUT,
				new ZooKeeperWatcher());
		zooKeeper.addAuthInfo(ZookeeperConstant.SCHEME, ZookeeperConstant.AUTH.getBytes());
		return zooKeeper;
	}
}
