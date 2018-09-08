package com.netease.explore.spring.web.jdk;

import com.netease.explore.core.random.Water;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaterDisaster {

  private Logger logger = LoggerFactory.getLogger(WaterDisaster.class);
  private List<Water> waterList;

  @RequestMapping("/disaster")
  public void disaster(Integer size) throws InterruptedException {

    logger.info("创建");
    waterList = Water.newRandomWaters(size);
    logger.info("开始等待");
    TimeUnit.SECONDS.sleep(100);
  }
}
