package com.netease.explore.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringContext implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContext.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  /**
   * 通过外部设置IOC容器
   */
  public static void setApplicationContextByOuter(ApplicationContext applicationContext) {
    SpringContext.applicationContext = applicationContext;
  }
}