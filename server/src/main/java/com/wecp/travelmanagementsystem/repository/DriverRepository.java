package com.wecp.travelmanagementsystem.repository;


import com.wecp.travelmanagementsystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Additional driver-related query methods can be added here
}

