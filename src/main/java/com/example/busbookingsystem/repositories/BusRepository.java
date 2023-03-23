package com.example.busbookingsystem.repositories;

import com.example.busbookingsystem.models.Bus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Bus b set b.name = :name where b.id = :id")
    public void update(@Param("name") String name, @Param("id") int id);
    public List<Bus> findAllBySourceIgnoreCaseAndDestinationIgnoreCase(String source,String destination);
}
