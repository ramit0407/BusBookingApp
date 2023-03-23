package com.example.busbookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numberOfSeats;
    private String name;
    @ElementCollection
    private List<String> availableDays;
    private String source;
    private String destination;
    private double distance;
    private double timeTaken;
    @Transient
    private int occupancy;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bus")
    private List<Seat> seats;

    public Bus(int id, int numberOfSeats, String name, List<String> availableDays, String source, String destination, double distance, double timeTaken, List<Seat> seats) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.name = name;
        this.availableDays = availableDays;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.timeTaken = timeTaken;
        occupancy++;
        this.seats = seats;
    }
}
