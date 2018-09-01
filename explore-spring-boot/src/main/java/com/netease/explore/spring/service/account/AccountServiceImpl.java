package com.netease.explore.spring.service.account;

import com.netease.explore.core.dao.BaseDaoServiceImpl;
import com.netease.explore.spring.dao.AccountDao;
import com.netease.explore.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseDaoServiceImpl<Account> implements AccountService
{

	@Autowired
	private AccountDao accountDao;
}
