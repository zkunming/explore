package com.netease.explore.spring.service.user;

import com.netease.explore.core.dao.BaseDaoService;
import com.netease.explore.spring.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangkunming
 */
public interface UserService extends BaseDaoService<User> {

  List<User> findByName(@Param("name") String name);

  /**
   * 事务测试
   **/
  void transaction();
}