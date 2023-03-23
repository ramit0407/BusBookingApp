package com.example.busbookingsystem.controllers;


import com.example.busbookingsystem.models.Bus;
import com.example.busbookingsystem.models.Seat;
import com.example.busbookingsystem.models.UserInfo;
import com.example.busbookingsystem.repositories.SeatRepository;
import com.example.busbookingsystem.services.BusService;
import com.example.busbookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BusService busService;

    @Autowired
    private UserService userService;

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/showBus/{source}/{destination}")
    public List<Bus> showBusBetSrcAndDest(@PathVariable String source,@PathVariable String destination){
        return busService.showBusBySourceAndDestination(source, destination);
    }
    @GetMapping("/availableSeats/{busId}")
    public int noOfSeatsAvailable(@PathVariable int busId){
        Bus bus = busService.get(busId);
        return bus.getNumberOfSeats() - bus.getOccupancy();
    }
    @PostMapping("/user/{userId}/bookBus/{busId}")
    public String bookBus(@PathVariable int userId,@PathVariable int busId){
        Bus bus = busService.get(busId);
        if(bus.getOccupancy()>=bus.getNumberOfSeats()/2){
            return "Book your seat on another bus";
        }
        UserInfo userInfo = userService.getTraveller(userId);
        Seat seat = new Seat(bus,userInfo);
        seatRepository.save(seat);
        return "Booked";
    }
    @DeleteMapping("/user/{userId}/cancelBooking/{busId}")
    public  String cancelBooking(@PathVariable int userId,@PathVariable int busId){
        Bus bus = busService.get(busId);
        UserInfo userInfo = userService.getTraveller(userId);
        seatRepository.deleteByBusAndUserInfo(bus,userInfo);
        return "Cancelled...";
    }
}
