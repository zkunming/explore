package com.netease.explore.core.random;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author zhangkunming
 */
public class Water {

  private String name;
  private String belong;

  public Water() {
  }

  public Water(String name, String belong) {
    this.name = name;
    this.belong = belong;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 一般不这么写，但是考虑到这个并非工程，所以暂时先这么写。
   */
  public static Water newRandomWater() {
    return new Water(RandomUtils.getTeaRandom(), RandomUtils.getRespectPeopleRandom());
  }

  /**
   * @param size
   * @return
   */
  public static List<Water> newRandomWaters(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("size can not be less than zero");
    }
    List<Water> waterList = Lists.newArrayList();
    for (int i = 0; i < size; i++) {
      waterList.add(Water.newRandomWater());
    }
    return waterList;
  }

  @Override
  public String toString() {
    return "Water{" +
        "name='" + name + '\'' +
        ", belong='" + belong + '\'' +
        '}';
  }
}
