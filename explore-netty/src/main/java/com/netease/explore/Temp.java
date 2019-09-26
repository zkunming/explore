package com.netease.explore;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Temp {

  public static void main(String[] args) throws InterruptedException {
    List<Bird> birds = Lists.newArrayList();
    for (int i = 0; i < 100000000; i++) {
      birds.add(new Bird("Hello"));
    }
    System.out.println(birds.size());

    TimeUnit.SECONDS.sleep(10000);

  }


  public static class Bird{

    private String name;

    public Bird(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
