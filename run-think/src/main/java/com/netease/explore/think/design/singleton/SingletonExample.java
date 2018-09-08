package com.netease.explore.think.design.singleton;

public class SingletonExample {

  public static void main(String[] args) {
    //1、懒懒的单例模式
    Singleton singleton = Singleton.getSingleton();
    singleton.hello();

    //2、懒汉式单例模式
    Singleton singletonByLazy = Singleton.getSingletonByLazy();
    singletonByLazy.hello();
  }
}
