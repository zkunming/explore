package com.netease.explore.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 概要：集成base服务类
 * 备注：
 * UPLOAD:需要被上传的object RESULT:集成返回的object
 */
public interface JiChenBaseService<UPLOAD, RESULT> {

  /**
   * 概要：获取数据源并存储
   */
  void getServiceDataAndSave(LocalDateTime begin, LocalDateTime end);

  /**
   * 概要：获取需要上传的数据
   */
  List<UPLOAD> getUploadData(LocalDate date);

  /**
   * 概要：处理集成返回的结果
   */
  void handleResult(List<RESULT> resultList);
}
