package com.example.busbookingsystem.controllers;

import com.example.busbookingsystem.models.UserInfo;
import com.example.busbookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user/add")
    public String add(@RequestBody UserInfo userInfo){
        userService.add(userInfo);
        return "Added";
    }
}
