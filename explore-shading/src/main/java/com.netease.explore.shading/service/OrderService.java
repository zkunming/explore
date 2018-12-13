package com.netease.explore.shading.service;

import java.util.List;

public interface OrderService{

    int insert(Order order);

    int insertSelective(Order order);

    int insertList(List<Order> orders);

    int update(Order order);
}
