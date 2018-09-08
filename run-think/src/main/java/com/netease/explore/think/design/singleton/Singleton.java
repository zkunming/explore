package com.netease.explore.think.design.singleton;

public class Singleton {

  private Singleton() {

  }

  private static Singleton singleton = new Singleton();

  /**
   * 返回单例
   */
  public static Singleton getSingleton() {
    return singleton;
  }

  /**
   * 说明：如果是使用懒加载，那么成员变量 singleton = null; 而不是 singleton = new Singleton();
   */
  public static Singleton getSingletonByLazy() {
    if (singleton != null) {
      return singleton;
    }
    synchronized (Singleton.class) {
      if (singleton == null) {
        singleton = new Singleton();
      }
    }
    return singleton;
  }

  public void hello() {
    System.out.println("Hello Singleton!");
  }
}
