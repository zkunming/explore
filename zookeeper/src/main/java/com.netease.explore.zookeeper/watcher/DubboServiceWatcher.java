package com.netease.explore.zookeeper.watcher;

import com.netease.explore.core.util.Printer;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DubboServiceWatcher implements Watcher
{
	private ZooKeeper zooKeeper;

	private int watchNumber = 0;

	public DubboServiceWatcher(ZooKeeper zooKeeper)
	{
		this.zooKeeper = zooKeeper;
	}

	@Override
	public void process(WatchedEvent event)
	{
		watchNumber = watchNumber + 1;

		System.out.println("第【 " + watchNumber + " 】次监听");
		try
		{
			//打印元数据
			Printer.testPrint(event);
			//重新设置监听
			zooKeeper.exists(event.getPath(), this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
