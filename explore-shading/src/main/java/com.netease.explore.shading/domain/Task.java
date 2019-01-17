package com.netease.explore.shading.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;

/**
 * 概要：task记录
 */
public class Task {

  /**
   * 主键ID
   */
  private Long id;
  /**
   * 创建时间
   */
  private LocalDateTime createTime;
  /**
   * 更新时间
   */
  private LocalDateTime updateTime;
  /**
   * JOB时间
   */
  private LocalDate date;
  /**
   * 状态
   */
  private String status;
  /**
   * 类型
   */
  private String type;
  /**
   * 时间切点
   */
  private LocalDateTime checkpointDate;

  /**
   * 备注
   */
  private String note;


  /**
   * 概要：创建初始化状态的job
   */
  public static Task newInitJob(LocalDate date, String type) {
    if (date == null || StringUtils.isBlank(type)) {
      throw new NullPointerException("date or type is null");
    }
    Task task = new Task();
    task.setCreateTime(LocalDateTime.now());
    task.setUpdateTime(LocalDateTime.now());
    task.setDate(date);
    task.setStatus("INIT");
    task.setType(type);
    task.setCheckpointDate(LocalDateTime.now());
    return task;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public LocalDateTime getCheckpointDate() {
    return checkpointDate;
  }

  public void setCheckpointDate(LocalDateTime checkpointDate) {
    this.checkpointDate = checkpointDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
