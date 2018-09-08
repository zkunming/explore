package com.netease.explore.spring.dao;

import com.netease.explore.spring.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

  int insert(User user);

  int insertSelective(@Param("user") User user);

  int insertList(@Param("users") List<User> users);

  List<User> findByName(@Param("name") String name);
}
