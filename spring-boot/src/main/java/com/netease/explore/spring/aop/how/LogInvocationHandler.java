package com.netease.explore.spring.aop.how;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author zhangkunming
 */
public class LogInvocationHandler implements InvocationHandler
{

	private static final Logger LOGGER = LoggerFactory.getLogger(LogInvocationHandler.class);
	/**
	 * 接口的实现类
	 */
	private Object target;

	public LogInvocationHandler(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		for (Object arg : args)
		{
			LOGGER.info("aop log 切入前。。,请求参数：{} " + JSON.toJSONString(arg));
		}
		Object result = method.invoke(target, args);
		LOGGER.info("aop log 切入后。。。，返回值：{}", JSON.toJSONString(result));
		return result;
	}
}
