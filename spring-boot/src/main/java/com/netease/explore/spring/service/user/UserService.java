package com.netease.explore.spring.service.user;

import com.netease.explore.spring.domain.User;
import com.netease.explore.core.dao.BaseDaoService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangkunming
 */
public interface UserService extends BaseDaoService<User>
{
	List<User> findByName(@Param("name") String name);

	/** 事务测试 **/
	void transaction();
}