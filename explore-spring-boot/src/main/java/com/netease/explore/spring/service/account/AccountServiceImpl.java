package com.netease.explore.spring.service.account;

import com.netease.explore.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {

  @Autowired
  private AccountDao accountDao;
}
