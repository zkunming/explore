package com.netease.explore.spring.enums.jichen;

import lombok.Getter;

/**
 * 概要：投保相关业务数据状态
 */
@Getter
public enum InsureCommonStatusEnum {
  INIT("INIT", "初始化"),
  RETRY("RETRY", "重试"),
  SUCCESS("SUCCESS", "成功"),
  ERROR("ERROR", "失败");

  private String name;
  private String desc;

  InsureCommonStatusEnum(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }
}
