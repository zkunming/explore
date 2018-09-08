package com.netease.explore.think.jdk8character;

import com.netease.explore.core.random.Water;
import java.util.List;

public class Lambada {

  public static void easyExample() {
    //我只是需要一次性的匿名函数，没有任何通用性！而且我想把这个函数当成一个局部变量，直接赋值
    Hello helloWordFun = name -> {
      System.out.println("Hello world!");
    };
    helloWordFun.hi("HI 梁飞");
    helloWordFun.love();
    Hello.helloStatic();
  }

  public static void stream() {
    List<Water> waterList = Water.newRandomWaters(10);
    waterList.stream().map(water -> {
      return water.getName();
    }).forEach(name -> {

    });
  }

  public static void main(String[] args) {
    easyExample();
  }
}

/**
 * 定义@FunctionalInterface ，则以后其他程序员就不能增加这个接口的方法啦！
 */
@FunctionalInterface
interface Hello {

  void hi(String name);

  default void love() {
    System.out.println("love");
  }

  static void helloStatic() {
    System.out.println("hello static");
  }
}

class HelloImpl implements Hello {

  @Override
  public void hi(String name) {
    System.out.println("I am helloImpl :" + name);
  }
}
