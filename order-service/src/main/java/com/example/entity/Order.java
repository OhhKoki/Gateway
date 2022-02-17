package com.example.entity;

import com.example.dto.UserDTO;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private UserDTO userDTO;
}