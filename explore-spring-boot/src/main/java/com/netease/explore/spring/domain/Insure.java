package com.netease.explore.spring.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 概要：投保信息
 */
@Getter
@Setter
public class Insure {

  /**
   * 主键id
   */
  private Long id;
  /**
   * 申请人
   */
  private String applyName;
  /**
   * 申请人证件类型
   */
  private String certificateType;
  /**
   * 申请件证件号码
   */
  private String certificateNum;

  /**
   * 申请人手机号码
   */
  private String phoneNum;

  /**
   * 借款用途/品种
   */
  private String purpose;

  /**
   * 借款本金
   */
  private BigDecimal borrowPrincipal;

  /**
   * 借款利率
   */
  private BigDecimal borrowInterestRate;

  /**
   * 借款利息
   */
  private BigDecimal borrowInterest;


  /**
   * 借款期限
   */
  private Integer borrowDeadline;

  /**
   * 借款起期
   */
  private Date borrowBeginDate;
  /**
   * 借款止期
   */
  private Date borrowEndDate;

  /**
   * 借款合同编号
   */
  private String loanId;

  /**
   * 还款方式
   */
  private String repayType;

  /**
   * 申请出函金额 即贷款本息/期限=（6+8）/9
   */
  private BigDecimal applyAmount;

  /**
   * 担保费率
   */
  private Double guaranteeRate;

  /**
   * 担保费用
   */
  private BigDecimal guaranteeFee;

  /**
   * 担保合同编号
   */
  private String guaranteeNum;

  /**
   * 犹豫期天数
   */
  private Integer hesitateDay;

  /**
   * 还款次数
   */
  private Integer repayCount;
}
