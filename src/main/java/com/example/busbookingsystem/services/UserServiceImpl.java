package com.example.busbookingsystem.services;


import com.example.busbookingsystem.models.UserInfo;
import com.example.busbookingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    @Override
    public UserInfo getTraveller(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
