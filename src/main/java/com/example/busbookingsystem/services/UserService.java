package com.example.busbookingsystem.services;


import com.example.busbookingsystem.models.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void add(UserInfo userInfo);
    UserInfo getTraveller(int id);
}
