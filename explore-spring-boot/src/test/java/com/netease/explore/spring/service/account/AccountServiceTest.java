package com.netease.explore.spring.service.account;

import com.netease.explore.spring.BaseMockTest;
import com.netease.explore.spring.domain.Account;
import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends BaseMockTest {

  @Autowired
  private AccountService accountService;

  @Test
  public void insert() {
    Account account = new Account();
    account.setId(getDistributeId());
    account.setUserId(getDistributeId());
    account.setBalance(new BigDecimal("1000"));
    account.setType("cyn");
    account.setVersion(1);

    accountService.insert(account);
  }

  @Test
  public void insertSelective() {
  }

  @Test
  public void insertList() {
  }

  @Test
  public void update() {
  }
}