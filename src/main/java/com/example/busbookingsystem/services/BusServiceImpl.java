package com.example.busbookingsystem.services;

import com.example.busbookingsystem.models.Bus;
import com.example.busbookingsystem.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository busRepository;

    @Override
    public void add(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public void delete(int id) {
        busRepository.deleteById(id);
    }

    @Override
    public void update(String name, int id) {
        busRepository.update(name,id);
    }

    @Override
    public List<Bus> showBusBySourceAndDestination(String source, String destination) {
        return busRepository.findAllBySourceIgnoreCaseAndDestinationIgnoreCase(source,destination);
    }

    @Override
    public Bus get(int id) {
        return busRepository.findById(id).orElse(null);
    }
}
