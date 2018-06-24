package com.netease.explore.spring.dao;

import com.google.common.collect.Lists;
import com.netease.explore.spring.BaseMockTest;
import com.netease.explore.spring.domain.User;
import com.netease.explore.spring.util.MockUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseMockTest
{

	@Autowired
	private UserDao userDao;

	@Test
	public void insert()
	{
		userDao.insert(new User());
	}

	@Test
	public void insertSelective()
	{
		userDao.insertSelective(new User());
	}

	@Test
	public void insertList()
	{
		userDao.insertList(Lists.newArrayList(MockUtil.getMockUser()));
	}

	@Test
	public void update()
	{

	}

	@Test
	public void findById()
	{
		User user = userDao.findById("1");
		Assert.assertNotNull(user);
	}

	@Test
	public void findByName()
	{
		List<User> userList = userDao.findByName("xixi");
		Assert.assertNotNull(userList);
	}
}