package com.netease.explore.spring.aop;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class People
{
	private String id;
	private String name;

	public static void main(String[] args)
	{
		/*System.out.println("heelo  asjdka j kjasdkjz xmn m sdjkjlj");

		//1、快捷键
		List<People> peopleList = Lists.newArrayList();

		List<People> people = Lists.newArrayList();

		//2、先去用这个类，那天用的爽，想要深入去了解

		//3、怎么去看源码
		peopleList.add(new People("", ""));*/


		BigDecimal accountBalance = getAccountBalance(null);

		System.out.println(accountBalance);

	}

	public static BigDecimal getAccountBalance(String username)
	{
		//1、判断参数是否有问题
		if (username == null || username.length() == 0)
		{
			throw new IllegalArgumentException("username is null");
		}
		//1、根据username去查询数据库
		//2、返回结果
		return null;
	}

	public static void dec(String fromUserId,String toUserId,BigDecimal money)
	{
		//1、Spring ()（把你的请求，跳到controller层---> 业务层(UserService)--》操作数据库、缓存）、Mybatics （操作数据库）
		//1、判断参数是否有问题
		//2、业务逻辑
		//2.1、拉取fromUserId的账户，判断一下是否有余额，
		//2.2 扣减fromUserId这个账户100块 update user set balance = balance - 100 where userid = 'fromUserId'
		//2.3 加touserid这个账户100块 up... where user id = 'toUserId'
		// 3、最终是不是要返回数据
	}

	public People(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
