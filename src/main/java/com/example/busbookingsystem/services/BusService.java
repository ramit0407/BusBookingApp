package com.example.busbookingsystem.services;

import com.example.busbookingsystem.models.Bus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusService {
    void add(Bus bus);
    void delete(int id);
    void update(String name,int id);
    List<Bus> showBusBySourceAndDestination(String source,String destination);
    Bus get(int id);
}
