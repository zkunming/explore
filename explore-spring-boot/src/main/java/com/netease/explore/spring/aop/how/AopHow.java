package com.netease.explore.spring.aop.how;

import com.netease.explore.spring.domain.User;

public interface AopHow {

  /**
   * @param user 方法返回值
   * @return 用户
   */
  User how(User user);

  String helloWord(String name);

}
