package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryByUserId(@PathVariable("orderId") Long orderId) {
        log.info("订单 id 为：" + orderId);
        // 根据id查询订单并返回
        return orderService.queryById(orderId);
    }

    @GetMapping(value = "/token")
    public String getToken(@RequestHeader(value = "token") String token) {
        return token;
    }

    @GetMapping(value = "/uuid")
    public String getUuid(@RequestHeader(value = "uuid") String token) {
        return token;
    }

}
