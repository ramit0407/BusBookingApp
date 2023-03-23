package com.example.busbookingsystem.repositories;

import com.example.busbookingsystem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {

}


