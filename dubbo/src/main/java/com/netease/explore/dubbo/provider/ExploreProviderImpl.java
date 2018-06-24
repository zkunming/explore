package com.netease.explore.dubbo.provider;

import com.netease.explore.dubbo.api.ExploreService;
import com.netease.explore.dubbo.api.dto.Result;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ExploreProviderImpl implements ExploreService
{

	@Override
	public Result explore(String explorer)
	{
		System.out.println("【Provider】：欢迎到访者：" + explorer);
		return new Result(explorer + " 开始探索世界...");
	}

	public static void main(String[] args) throws IOException
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"dubbo-provider.xml"});
		context.start();

		System.in.read();
	}
}
