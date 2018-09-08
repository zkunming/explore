package com.netease.explore.zookeeper.temp;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Temp {

  private static final Logger logger = LoggerFactory.getLogger(Temp.class);

  public static void main(String[] args) throws InterruptedException {

    while (true) {
      MDC.put("requestId", UUID.randomUUID().toString());
      logger.debug("debug类型。。。");
      logger.info("info类型。。。");
      logger.warn("warn类型。。。");
      logger.error("error类型。。。");
      MDC.clear();
      TimeUnit.SECONDS.sleep(2);
    }
  }
}
