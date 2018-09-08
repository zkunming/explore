package com.netease.explore.dubbo.api.dto;

import java.io.Serializable;

public class Result implements Serializable {

  private static final long serialVersionUID = -4963266899668807475L;

  private String value;

  public Result(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
