package com.netease.explore.think.design.strategy;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  /**
   * 商品id
   */
  private Long id;
  /**
   * 价格
   */
  private BigDecimal price;

  /**
   * 商品名称
   */
  private String name;
}
