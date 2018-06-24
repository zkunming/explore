package com.netease.explore.spring;

import com.netease.explore.core.util.SnowflakeIdWorker;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseMockTest
{
	@Autowired
	private SnowflakeIdWorker snowflakeIdWorker;

	public String getDistributeId()
	{
		return String.valueOf(snowflakeIdWorker.nextId());
	}
}
