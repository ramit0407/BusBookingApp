package com.example.busbookingsystem.controllers;

import com.example.busbookingsystem.models.Bus;
import com.example.busbookingsystem.models.UserInfo;
import com.example.busbookingsystem.services.BusService;
import com.example.busbookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bus/user/{userId}")
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private UserService userService;

    private String message1 = "User Not Exist";
    private String message2 = "You are not authorized..";
    private String message3 = "false";
    @PostMapping("/add")
    public String add(@RequestBody Bus bus, @PathVariable int userId){
        UserInfo userInfo = userService.getTraveller(userId);
        if(userInfo ==null){
            return message1;
        }else if(userInfo.getIsAdmin().equals(message3)){
            return message2;
        }
        busService.add(bus);
        return "Added";
    }
    @DeleteMapping("/delete/{busId}")
    public String delete(@PathVariable int userId,@PathVariable int busId){
        UserInfo userInfo = userService.getTraveller(userId);
        if(userInfo ==null){
            return message1;
        }else if(userInfo.getIsAdmin().equals(message3)){
            return message2;
        }
        busService.delete(busId);
        return "Deleted...";
    }
    @PatchMapping("update/{busId}/{name}")
    public String update(@PathVariable int busId,@PathVariable int userId,@PathVariable String name){
        UserInfo userInfo = userService.getTraveller(userId);
        if(userInfo ==null){
            return message1;
        }else if(userInfo.getIsAdmin().equals(message3)){
            return message2;
        }
        busService.delete(busId);
        return "Updated...";
    }
}
