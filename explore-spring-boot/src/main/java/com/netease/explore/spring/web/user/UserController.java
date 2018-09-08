package com.netease.explore.spring.web.user;

import com.netease.explore.spring.domain.User;
import com.netease.explore.spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/user")
  public User getUser() {
    User user = userService.findById("1");
    return user;
  }

  @RequestMapping("/t")
  public void transaction() {
    userService.transaction();
  }
}
