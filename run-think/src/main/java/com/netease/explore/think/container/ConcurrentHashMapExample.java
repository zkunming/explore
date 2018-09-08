package com.netease.explore.think.container;

import com.netease.explore.core.random.RandomUtils;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

  private static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
  private static String key = RandomUtils.getRandomStr();
  private static String value = RandomUtils.getRandomStr();

  public static void operate() {
    concurrentHashMap.put(key, "12");
    concurrentHashMap.get(key);
    int size = concurrentHashMap.size();

  }

  public static void main(String[] args) {
    operate();
  }
}
