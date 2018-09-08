package com.netease.explore.spring.service.user;

import com.netease.explore.spring.BaseMockTest;
import com.netease.explore.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseMockTest {

  @Autowired
  private UserService userService;

  @Test
  public void testTransaction() {
    userService.transaction();
  }

  @Test
  public void testFindById() {
    User user = userService.findById("1");
    Assert.assertNotNull(user);
  }

  @Test
  public void testInsert() {
    User user = new User();
    user.setId(getDistributeId());
    user.setName("testHelloMock test");
    userService.insert(user);
  }
}