package com.netease.explore.dubbo.consumer;

import com.netease.explore.dubbo.api.ExploreService;
import java.util.concurrent.TimeUnit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExploreConsumer {

  public static void main(String[] args) throws InterruptedException {
    //初始化spring容器
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        new String[]{"dubbo-consumer.xml"});
    context.start();

    //服务调用
    ExploreService exploreService = (ExploreService) context.getBean("exploreService");
    for (int i = 0; i < 100; i++) {
      String value = exploreService.explore("张坤铭").getValue();
      System.out.println(value);
      TimeUnit.SECONDS.sleep(3);
    }
  }
}
