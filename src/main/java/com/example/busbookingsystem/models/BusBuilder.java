package com.example.busbookingsystem.models;

import java.util.List;

public class BusBuilder {
    private int id;
    private int numberOfSeats;
    private String name;
    private List<String> availableDays;
    private String source;
    private String destination;
    private double distance;
    private double timeTaken;
    private List<Seat> seats;

    public BusBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BusBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public BusBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BusBuilder setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
        return this;
    }

    public BusBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public BusBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public BusBuilder setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public BusBuilder setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
        return this;
    }

    public BusBuilder setSeats(List<Seat> seats) {
        this.seats = seats;
        return this;
    }

    public Bus createBus() {
        return new Bus(id, numberOfSeats, name, availableDays, source, destination, distance, timeTaken, seats);
    }
}