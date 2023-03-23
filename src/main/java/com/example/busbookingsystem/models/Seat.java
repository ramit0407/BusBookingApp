package com.example.busbookingsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bus bus;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public Seat(Bus bus, UserInfo userInfo) {
        this.bus = bus;
        this.userInfo = userInfo;
    }
}
