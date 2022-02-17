package com.example.client;

import com.example.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping(value = "/user/{id}")
    UserDTO selectById(@PathVariable(value = "id") Long id);

}
