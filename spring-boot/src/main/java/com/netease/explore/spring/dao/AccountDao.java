package com.netease.explore.spring.dao;

import com.netease.explore.core.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.netease.explore.spring.domain.Account;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao extends BaseDao<Account>{

    int insertSelective(@Param("account") Account account);

    int insertList(@Param("accounts") List<Account> accounts);

    Account findByUserIdAndType(@Param("userId")String userId,@Param("type")String type);
}
