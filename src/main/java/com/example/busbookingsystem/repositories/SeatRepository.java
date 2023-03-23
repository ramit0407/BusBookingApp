package com.example.busbookingsystem.repositories;

import com.example.busbookingsystem.models.Bus;
import com.example.busbookingsystem.models.Seat;
import com.example.busbookingsystem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    void deleteByBusAndUserInfo(Bus bus, UserInfo userInfo);
}
