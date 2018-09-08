package com.netease.explore.core.random;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class RandomUtils {

  /**
   * 随机数
   */
  public static Random teaRandom = new Random();
  public static String teaContent = "碧螺春、信阳毛尖、西湖龙井、君山银针、黄山毛峰、武夷岩茶、祁门红茶、都匀毛尖、铁观音、六安瓜片";
  public static List<String> teaList;

  public static String respectPeopleContent = "梁飞-dubbo、远鸿-阿里导师、吴军-见识（偶像）、马云-马叔叔";
  public static Random respectPeopleRandom = new Random();
  public static List<String> respectPeopleList;

  public static Random numberRandom = new Random();

  static {
    String[] teaSplit = teaContent.split("、");
    teaList = Lists.newArrayList(teaSplit);

    String[] respectPeopleSplit = respectPeopleContent.split("、");
    respectPeopleList = Lists.newArrayList(respectPeopleSplit);
  }

  /**
   * 获取随机的茶叶
   */
  public static String getTeaRandom() {
    int randomIndex = teaRandom.nextInt(teaList.size());
    return "茶叶 ：" + teaList.get(randomIndex);
  }

  /**
   * 获取随机受尊敬people
   */
  public static String getRespectPeopleRandom() {
    int randomIndex = respectPeopleRandom.nextInt(respectPeopleList.size());
    return "受尊敬的人：" + respectPeopleList.get(randomIndex);

  }

  /**
   * 返回随机数
   */
  public static String getRandomStr() {
    return String.valueOf(numberRandom.nextInt(100000000));
  }
}
