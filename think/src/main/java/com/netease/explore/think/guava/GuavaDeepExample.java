package com.netease.explore.think.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class GuavaDeepExample
{
	public static void main(String[] args) throws InterruptedException
	{
		RateLimiter rateLimiter = RateLimiter.create(10);

		TimeUnit.SECONDS.sleep(100);
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i + " : " + rateLimiter.acquire());
		}

		System.out.println("出来啦");
	}
}
