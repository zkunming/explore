package com.netease.explore.think.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;
import com.netease.explore.core.util.Printer;
import com.netease.explore.core.random.Water;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaSimpleExample {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    //1、Collection集合
    collectionExample();
    //2、缓存
    cacheExample();
    //3、Multimap

    //泡杯茶吧，不返回了
    CountDownLatch countDownLatch = new CountDownLatch(1);
    countDownLatch.await();
  }

  /**
   * guava集合操作
   */
  private static void collectionExample() {
    List<Water> waterList = Lists.newArrayList(Water.newRandomWater());

    CopyOnWriteArrayList<Water> waterCopyOnWriteArrayList = Lists
        .newCopyOnWriteArrayList(waterList);
    waterCopyOnWriteArrayList.add(Water.newRandomWater());
    Printer.testPrint(waterList);
    Printer.testPrint(waterCopyOnWriteArrayList);
  }

  /**
   * guava缓存
   */
  public static void cacheExample() throws InterruptedException, ExecutionException {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        .maximumSize(10)
        .expireAfterWrite(2, TimeUnit.SECONDS)
        .removalListener(new RemovalListener<String, String>() {
          @Override
          public void onRemoval(RemovalNotification<String, String> notification) {
            StringBuilder builder = new StringBuilder();
            RemovalCause cause = notification.getCause();
            builder.append("cause: " + cause + ", content: " + JSON.toJSONString(notification));
            Printer.testPrint(builder.toString());
          }
        })
        .build();

    for (int i = 0; i < 20; i++) {
      cache.put(i + "", new String(i + ""));
    }
    TimeUnit.SECONDS.sleep(3);

    String content = cache.get("19", new Callable<String>() {
      @Override
      public String call() throws Exception {
        return "哈哈哈";
      }
    });

    System.out.println(content);
    System.out.println(cache.size());
  }
}