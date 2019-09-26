package com.netease.explore.think.design.strategy;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 价格计算器
 */
public class PriceCalculator {

  /**
   * 概要：价格计算器
   */
  public static BigDecimal calculate(PriceCalculateRequest calculateRequest) {

    Reduction reduction = null;
    //满1000元 减 200元 ，满100件，减200元

    BigDecimal bigDecimal = reduction.calculatePrice(null);

    return null;
  }

  @Getter
  @Setter
  public static class PriceCalculateRequest {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 商品列表
     */
    private List<Product> productList;
  }

  /**
   * 概要：返回总价
   */
  @Getter
  @Setter
  public static class PriceCalculateResponse {
    private BigDecimal totalPrice;

  }
}
