package com.netease.explore.core.util;

import com.google.common.collect.Maps;
import com.netease.explore.core.enums.DatePatternEnum;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * 概要：时间工具类
 */
public final class DateUtils {

  private DateUtils(){}

  private static Map<DatePatternEnum, DateTimeFormatter> dateTimeFormatterMap = initDateTimeFormatterMap();

  /**
   * 概要：初始化dateTimeFormatterMap
   */
  private static Map<DatePatternEnum, DateTimeFormatter> initDateTimeFormatterMap() {
    Map<DatePatternEnum, DateTimeFormatter> dateTimeFormatterMap = Maps.newHashMap();
    for (DatePatternEnum datePatternEnum : DatePatternEnum.values()) {
      dateTimeFormatterMap
          .put(datePatternEnum, DateTimeFormatter.ofPattern(datePatternEnum.getPattern()));
    }
    return dateTimeFormatterMap;
  }


  /**
   * 概要：根据时间pattern获取DateTimeFormatter
   */
  public static DateTimeFormatter getDateTimeFormatter(DatePatternEnum datePatternEnum) {
    return dateTimeFormatterMap.get(datePatternEnum);
  }


  /**
   * 概要：获取当天的开始时间
   * 例如：2018-12-10 14:00 ---》 返回时间：2018-12-10 00:00
   */
  public static LocalDateTime getDayStartTime(LocalDateTime localDateTime) {
    if (localDateTime == null) {
      throw new NullPointerException("localDateTime is null");
    }
    return LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN);
  }
}
