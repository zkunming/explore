package com.netease.explore.spring.util;

import com.netease.explore.core.SpringContext;
import com.netease.explore.core.random.RandomUtils;
import com.netease.explore.core.util.SnowflakeIdWorker;
import com.netease.explore.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * mock工具类
 *
 * @author zhangkunming
 */
public final class MockUtil {

  @Autowired
  private static SnowflakeIdWorker snowflakeIdWorker;

  {
    snowflakeIdWorker = (SnowflakeIdWorker) SpringContext.getBean("snowflakeIdWorker");
  }

  public static User getMockUser() {
    User user = new User();
    //user.setId(snowflakeIdWorker.nextId());
    user.setName(RandomUtils.getTeaRandom());
    return user;
  }
}
