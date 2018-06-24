package com.netease.explore.zookeeper.util;

import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;

/**
 * 封装zookeeper节点信息
 */
public class ZooKeeperNode
{
	private Object data;
	private Stat stat;

	public ZooKeeperNode(byte[] bytes, Stat stat) throws UnsupportedEncodingException
	{
		this.data = new String(bytes, "UTF-8");
		this.stat = stat;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public Stat getStat()
	{
		return stat;
	}

	public void setStat(Stat stat)
	{
		this.stat = stat;
	}
}
