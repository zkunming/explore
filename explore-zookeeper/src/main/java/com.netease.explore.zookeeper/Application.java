package com.netease.explore.zookeeper;

import com.netease.explore.core.random.RandomUtils;
import com.netease.explore.core.util.Printer;
import com.netease.explore.zookeeper.common.ZookeeperConstant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  private final static Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    //1、创建zookeeper
    CuratorFramework client = CuratorFrameworkFactory.builder()
        //1、设置创建节点时的ACL
        //.aclProvider(new NewFinanceACLProvider())
        //2、设置操作节点的ACL
        .authorization(ZookeeperConstant.SCHEME, ZookeeperConstant.AUTH.getBytes())
        //3、连接zookeeper设置
        .connectString(ZookeeperConstant.CONNECT_STRING)
        .connectionTimeoutMs(ZookeeperConstant.SESSION_TIMEOUT)
        .retryPolicy(new RetryNTimes(5, 2000))
        .defaultData("默认值".getBytes())
        .build();

    client.start();

    final String path = "/zkm/not-acl";
    //2、创建节点
    if (client.checkExists().forPath(path) != null) {
      client.delete().deletingChildrenIfNeeded().forPath(path);
    }
    client.create()
        .creatingParentsIfNeeded()
        .withMode(CreateMode.PERSISTENT)
        //如果在创建clientde时候设置过AclProvider那就不需要在额外设置这个选项
        //.withACL(NewFinanceACLProvider.aclList)
        .forPath(path, "菊花茶".getBytes());

    //4、设置监听--[场景：我有一个服务，对应的path：/zkm/example,我需要知道变化]
		/*final NodeCache nodeCache = new NodeCache(client, path);
		nodeCache.getListenable().addListener(new NodeCacheListener()
		{
			@Override
			public void nodeChanged() throws Exception
			{
				StringBuilder builder = new StringBuilder();
				builder.append("监听：");
				builder.append(nodeCache.getPath() + " : " + new String(nodeCache.getCurrentData().getData(), "UTF-8"));
				Printer.testPrint(builder.toString());
			}
		});
		nodeCache.start();*/

		/*final PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path, true);
		pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener()
		{
			@Override
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception
			{
				PathChildrenCacheEvent.Type type = event.getType();
				ChildData data = event.getData();
			}
		});
		pathChildrenCache.start();*/

    final TreeCache treeCache = new TreeCache(client, path);
    treeCache.getListenable().addListener(new TreeCacheListener() {
      @Override
      public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
        TreeCacheEvent.Type type = event.getType();
        ChildData data = event.getData();

        StringBuilder builder = new StringBuilder();
        builder.append("类型: " + type);
        if (data == null) {
          return;
        }
        Printer.testPrint(event);

        builder.append("， 数据： " + new String(data.getData(), "UTF-8"));
        builder.append("， 其他数据:" + data);
        System.out.printf(builder.toString());
      }
    });
    treeCache.start();

    //【S】加入以为品茶老者
    product(client, path);

    //【S】 泡杯咖啡杯
    CountDownLatch countDownLatch = new CountDownLatch(2);
    countDownLatch.await();
  }

  public static void product(final CuratorFramework client, final String path) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          logger.info("进入品茶线程。。。。");
          try {
            client.setData().forPath(path, RandomUtils.getTeaRandom().getBytes());
            TimeUnit.SECONDS.sleep(2);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

      }
    }, "品茶老者").start();
  }

  public static void print() {

  }
}
