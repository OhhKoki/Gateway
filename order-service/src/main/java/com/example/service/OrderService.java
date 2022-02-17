package com.example.service;

import com.example.entity.Order;

public interface OrderService {

    Order queryById(Long orderId);

}
