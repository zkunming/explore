package com.netease.explore.zookeeper.dto;

import java.util.Random;

/**
 * Dubbo类
 */
public class Dubbo
{
	/**
	 * 节点路径
	 */
	private String path;
	private String name;
	private String description;
	private String author;
	private String createTime;

	public Dubbo()
	{
	}

	public Dubbo(String name, String description, String author, String createTime)
	{
		this.name = name;
		this.description = description;
		this.author = author;
		this.createTime = createTime;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public void randomSet()
	{
		Random random = new Random();
		String randomValue = random.nextInt(1000) + "";

		this.path = randomValue;
		this.name = randomValue;
		this.author = "梁飞";
	}
}
