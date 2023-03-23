package com.example.busbookingsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private long mobileNo;
    private String isAdmin;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userInfo")
    private List<Seat> seat;
}
