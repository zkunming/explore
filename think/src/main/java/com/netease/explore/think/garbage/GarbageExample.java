package com.netease.explore.think.garbage;

public class GarbageExample
{
	private static int _1MB = 1024 * 1024;

	/**
	 *
	 -Xms20m
	 -Xmx20m
	 -Xmn10m
	 -XX:SurvivorRatio=8
	 -XX:+PrintGCDetails
	 -XX:+UseConcMarkSweepGC
	 */
	public static void test()
	{
		//8M 1M 1M
		//10M 10M
		MyObject m1 = new MyObject(_1MB / 2);
		MyObject m2 = new MyObject(_1MB * 4);
		MyObject m3 = new MyObject(_1MB * 4);

		System.out.println("结束");
	}

	/**
	 * main方法
	 */
	public static void main(String[] args)
	{
		test();
	}
}

/**
 * MyObject方法
 */
class MyObject
{
	private byte[] name;

	public MyObject(int size)
	{
		this.name = new byte[size];
	}

	public byte[] getName()
	{
		return name;
	}

	public void setName(byte[] name)
	{
		this.name = name;
	}
}
