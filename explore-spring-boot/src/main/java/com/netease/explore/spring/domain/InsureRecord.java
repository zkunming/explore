package com.netease.explore.spring.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 概要：投保记录表
 */
@Getter
@Setter
public class InsureRecord {

  /**
   * 主键id
   */
  private Long id;
  /**
   * 投保信息表ID
   */
  private Long insureId;
  /**
   * 担保/借款合同编号
   */
  private String loanId;
  /**
   * 期数
   */
  private int periodCount;
  /**
   * 保单号
   */
  private String guaranteeNum;
  /**
   * 投保最后期限
   */
  private Date insureDeadline;
  /**
   * 状态
   */
  private String status;

  /**
   * 备注
   */
  private String note;

  /**
   * 创建时间
   */
  private Date createTime;
  /**
   * 更新时间
   */
  private Date updateTime;

  /**
   * 数据发送时间
   */
  private String scheduleDate;
  /**
   * 还款日期
   */
  private Date repayDate;

  /**
   * 还款金额
   */
  private BigDecimal repayAmount;

  /**
   * 还款本金
   */
  private BigDecimal repayPrincipal;

  /**
   * 还款利息
   */
  private BigDecimal repayInterest;

  /**
   *
   */
  private Long lpayId;

}
