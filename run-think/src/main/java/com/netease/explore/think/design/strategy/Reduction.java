package com.netease.explore.think.design.strategy;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public interface Reduction {

  /**
   * 概要：计算价格
   */
  BigDecimal calculatePrice(ProductReductionWrap productWrap);

  /**
   * 概要：商品价格计算包装
   */
  @Getter
  @Setter
  public static class ProductReductionWrap {
    private List<Product> productList;
  }
}
