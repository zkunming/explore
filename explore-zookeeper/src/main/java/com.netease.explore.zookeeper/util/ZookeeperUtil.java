package com.netease.explore.zookeeper.util;

import com.netease.explore.core.util.Printer;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * zookeeper的工具类
 */
public class ZookeeperUtil
{
	private final static Logger LOGGER = LoggerFactory.getLogger(ZookeeperUtil.class);

	private ZookeeperUtil()
	{
	}

	/**
	 * 获取并打印数据
	 */
	public static void getAndPrintData(String path, ZooKeeper zooKeeper)
			throws KeeperException, InterruptedException, UnsupportedEncodingException
	{

		LOGGER.info("获取zookeeper数据,path：" + path);
		ZooKeeperNode data = getData(zooKeeper, path);
		Printer.testPrint(data);
	}

	/**
	 * 获取数据。并封装成Zookeeper返回
	 */
	public static ZooKeeperNode getData(ZooKeeper zooKeeper, String path)
			throws KeeperException, InterruptedException, UnsupportedEncodingException
	{
		Stat stat = new Stat();
		byte[] data = zooKeeper.getData(path, false, stat);
		return new ZooKeeperNode(data, stat);
	}

	/**
	 * 递归删除子节点[包含当前节点]
	 */
	public static void deleteByRecurrence(String path, ZooKeeper zooKeeper) throws KeeperException, InterruptedException
	{
		Stat stat = zooKeeper.exists(path, null);
		if (stat == null)
		{
			return;
		}
		List<String> childrenList = zooKeeper.getChildren(path, null);

		if (CollectionUtils.isEmpty(childrenList))
		{
			zooKeeper.delete(path, stat.getVersion());
			return;
		}
		//删除子节点
		for (String children : childrenList)
		{
			String childrenPath = path + "/" + children;
			deleteByRecurrence(childrenPath, zooKeeper);
		}
		//删除当前节点
		zooKeeper.delete(path, stat.getVersion());
	}
}
