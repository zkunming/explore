package com.netease.explore.spring.dao;

import com.netease.explore.core.dao.BaseDao;
import com.netease.explore.spring.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseDao<User>
{
	int insertSelective(@Param("user") User user);

	int insertList(@Param("users") List<User> users);

	List<User> findByName(@Param("name") String name);
}
