package com.netease.explore.spring.mock;

import com.netease.explore.spring.BaseMockTest;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

import java.time.Instant;

public class HelloMockTest extends BaseMockTest
{
	@Mocked
	private HelloMock helloMock;

	@Test
	public void testHelloMock()
	{
		final String helloParam = "Hi world!";
		new Expectations()
		{
			{
				helloMock.hello(helloParam);
				result = "I coming!";
			}
		};

		String hello = helloMock.hello(helloParam);
		System.out.println(hello);

		Instant instant = null;

	}
}
