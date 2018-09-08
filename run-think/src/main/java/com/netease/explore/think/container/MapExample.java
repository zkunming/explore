package com.netease.explore.think.container;

import com.google.common.collect.Maps;
import com.netease.explore.core.random.Water;
import java.util.Map;

/**
 * @author zhangkunming
 */
public class MapExample {

  public static void map() {
    //1、构造Map
    Map<String, Water> waterMap = Maps.newHashMap();

    //2、构造Water
    Water water = Water.newRandomWater();

    //3、跟进解读源码
    waterMap.put(water.getName(), water);
    Water waterFromMap = waterMap.get(water.getName());
    System.out.println(waterFromMap);
  }

  public static void main(String[] args) {
    //1、简单的功能
    map();
  }
}
