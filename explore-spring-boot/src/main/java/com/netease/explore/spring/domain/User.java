package com.netease.explore.spring.domain;

import com.netease.explore.core.dao.BaseDomain;

/**
 * 用户
 */
public class User extends BaseDomain {

  /**
   * 用户名
   */
  private String name;

  /**
   * get、set方法
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
