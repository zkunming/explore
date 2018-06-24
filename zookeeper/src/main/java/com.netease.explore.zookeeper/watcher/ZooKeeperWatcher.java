package com.netease.explore.zookeeper.watcher;

import com.netease.explore.core.util.Printer;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZooKeeperWatcher implements Watcher
{
	@Override
	public void process(WatchedEvent event)
	{
		//1、打印结果
		Printer.testPrint(event);
	}
}
