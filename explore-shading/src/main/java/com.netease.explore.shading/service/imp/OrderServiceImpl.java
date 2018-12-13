package com.netease.explore.shading.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.netease.explore.shading.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public int insert(Order order){
        return orderMapper.insert(order);
    }

    @Override
    public int insertSelective(Order order){
        return orderMapper.insertSelective(order);
    }

    @Override
    public int insertList(List<Order> orders){
        return orderMapper.insertList(orders);
    }

    @Override
    public int update(Order order){
        return orderMapper.update(order);
    }
}
