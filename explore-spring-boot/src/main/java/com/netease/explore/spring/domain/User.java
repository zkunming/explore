package com.netease.explore.spring.domain;

import com.netease.explore.core.dao.BaseDomain;

/**
 * 用户
 */
public class User {

  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
