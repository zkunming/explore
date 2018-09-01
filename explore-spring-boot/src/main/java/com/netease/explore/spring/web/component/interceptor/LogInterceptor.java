package com.netease.explore.spring.web.component.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangkunming
 */
public class LogInterceptor implements HandlerInterceptor
{
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	{
		logger.info("请求参数URI：" + request.getRequestURI() + ",   URL: " + request.getRequestURL());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{
		logger.info("返回接口信息：" + JSON.toJSONString(handler));
	}
}
