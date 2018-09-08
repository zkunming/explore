package com.netease.explore.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAOP {

  /**
   * sl4f日志输出
   */
  private static final Logger logger = LoggerFactory.getLogger(LogAOP.class);

  //Aop执行方法
  @Around("execution(public * com.netease.explore.spring..*())")
  public Object log(ProceedingJoinPoint joinPoint) {
    logger.info("有人来咯，小二上菜。。");
    long startTime = System.currentTimeMillis();
    long endTime = 0;
    try {
      Object result = joinPoint.proceed();
      return result;
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    } finally {
      endTime = System.currentTimeMillis();
      long speedTime = endTime - startTime;
      logger.info("有人走了，小二打扫卫生, 客人吃饭的时间为：" + speedTime);
    }
  }
}