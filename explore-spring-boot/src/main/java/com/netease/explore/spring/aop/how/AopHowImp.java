package com.netease.explore.spring.aop.how;

import com.netease.explore.spring.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aop实现
 * @author zhangkunming
 */
public class AopHowImp implements AopHow
{
	private final String name = "鹏飞";
	@Override
	public User how(User user)
	{
		user.setName(name+":how()");
		return user;
	}

	@Override
	public String helloWord(String name)
	{
		return name + ":helloWord()";
	}
}
