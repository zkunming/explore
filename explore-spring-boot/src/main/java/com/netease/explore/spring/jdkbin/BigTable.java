package com.netease.explore.spring.jdkbin;

import com.netease.explore.core.random.Water;
import java.util.List;

public class BigTable {

  List<Water> waters;

  {
    waters = Water.newRandomWaters(100);
  }
}
