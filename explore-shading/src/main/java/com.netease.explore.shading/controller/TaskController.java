package com.netease.explore.shading.controller;

import com.netease.explore.shading.dao.TaskMapper;
import com.netease.explore.shading.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskMapper taskMapper;

  @RequestMapping("/hello")
  public Task hello() {
    return taskMapper.findById(40l);
  }
}
