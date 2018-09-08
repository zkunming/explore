package com.netease.explore.core.monitor;

import com.google.common.base.Preconditions;

public class LatencyMonitor {

  /**
   * 开始时间
   */
  private Long startTime;
  /**
   * 结束时间
   */
  private Long endTime;
  /**
   * 花费时间
   */
  private Long speedTime;

  /**
   * 开始
   */
  public void start() {
    startTime = System.currentTimeMillis();
  }

  /**
   * 结束
   */
  public void end() {
    endTime = System.currentTimeMillis();
  }

  public Long getSpeesTime() {
    Preconditions.checkNotNull(startTime);
    Preconditions.checkNotNull(endTime);
    if (endTime.compareTo(startTime) < 0) {
      throw new RuntimeException("endTime less than startTime!");
    }
    return endTime - startTime;
  }

  //==========get and set 方法==========
  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }
}
