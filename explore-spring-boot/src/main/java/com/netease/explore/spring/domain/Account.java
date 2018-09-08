package com.netease.explore.spring.domain;

import com.netease.explore.core.dao.BaseDomain;
import java.math.BigDecimal;

/**
 * 账户表
 */
public class Account extends BaseDomain {

  /**
   * 用户id
   */
  private String userId;

  /**
   * 账户类型
   */
  private String type;
  /**
   * 账户余额
   */
  private BigDecimal balance;

  /**
   * 版本【数据库乐观锁控制】
   */
  private Integer version;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
