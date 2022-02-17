package com.example.controller;

import com.example.config.PatternProperties;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@RefreshScope    // 配置动态更新
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties properties;

//    @Value(value = "${pattern.dateformat}")
//    private String dateformat;

    @GetMapping(value = "/user/properties")
    public PatternProperties getPatternProperties() {
        return properties;
    }

    @GetMapping(value = "/user/now")
    public String getNow() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id) {
        log.info("用户 id 为：" + id);
        return userService.queryById(id);
    }

}
