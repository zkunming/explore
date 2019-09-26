package com.netease.explore.spring.enums.jichen;

import lombok.Getter;

/**
 * 概要：job状态枚举
 * 1、正常业务的job状态流转:INIT->SAVED->UPLOADING->UPLOADED->NOTIFIED->RECEIVED->SUCCESS
 * 2、续保业务的job状态流转:RECEIVED->SAVED->UPLOADING->UPLOADED->SUCCESS
 */
@Getter
public enum TaskStatusEnum {

  INIT("INIT", "初始化"),
  SAVED("SAVED", "入库"),
  UPLOADED("UPLOADED", "上传完成"),
  NOTIFIED("NOTIFIED", "通知完成"),
  RECEIVED("RECEIVED", "接收到通知"),
  SUCCESS("SUCCESS", "处理成功");

  private String name;
  private String desc;

  TaskStatusEnum(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }
}

