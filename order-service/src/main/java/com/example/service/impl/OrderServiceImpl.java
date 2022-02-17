package com.example.service.impl;

import com.example.client.UserClient;
import com.example.dto.UserDTO;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public Order queryById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 调用 user-service 服务查询用户信息
        UserDTO userDTO = userClient.selectById(order.getUserId());
        // 3. 将 user 设置到 order 中
        order.setUserDTO(userDTO);
        // 4. 返回
        return order;
    }

}
