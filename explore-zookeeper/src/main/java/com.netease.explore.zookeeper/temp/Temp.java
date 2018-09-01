package com.netease.explore.zookeeper.temp;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class Temp
{
	private static final Logger logger = LoggerFactory.getLogger(Temp.class);

	public static void main(String[] args) throws InterruptedException
	{

		while (true)
		{
			MDC.put("requestId", UUID.randomUUID().toString());
			logger.debug("debug类型。。。");
			logger.info("info类型。。。");
			logger.warn("warn类型。。。");
			logger.error("error类型。。。");
			MDC.clear();
			TimeUnit.SECONDS.sleep(2);
		}
	}
}
