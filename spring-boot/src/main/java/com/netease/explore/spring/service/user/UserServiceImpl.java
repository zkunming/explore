package com.netease.explore.spring.service.user;

import com.netease.explore.spring.domain.User;
import com.netease.explore.core.dao.BaseDaoServiceImpl;
import com.netease.explore.spring.util.MockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangkunming
 */
@Service
public class UserServiceImpl extends BaseDaoServiceImpl<User> implements UserService
{
	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@Autowired
	private UserService userService;

	@Override
	public List<User> findByName(String name)
	{
		return userService.findByName(name);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void transaction()
	{
		userService.insert(MockUtil.getMockUser());
		throw new RuntimeException("发生了运行一次了，观察数据库是否有回滚。");
	}
}
