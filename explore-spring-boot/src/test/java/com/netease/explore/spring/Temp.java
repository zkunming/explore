package com.netease.explore.spring;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class Temp
{
	@Test
	public void test()
	{
		int DEFAULT_INITIAL_CAPACITY = 1 << 4;
		System.out.println(DEFAULT_INITIAL_CAPACITY);

		Map<String, String> nameMap = Maps.newHashMap();
		nameMap.put("baby", "梁飞");
		nameMap.get("baby");
	}
}
