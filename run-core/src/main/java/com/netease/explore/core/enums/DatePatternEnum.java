package com.netease.explore.core.enums;

/**
 * 概要：提供常用时间pattern枚举
 */
public enum DatePatternEnum {
  YYYY_MM_DD("yyyy-MM-dd"),
  YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");


  /**
   * 概要：date pattern
   */
  private String pattern;

  DatePatternEnum(String pattern) {
    this.pattern = pattern;
  }

  public String getPattern() {
    return pattern;
  }
}
