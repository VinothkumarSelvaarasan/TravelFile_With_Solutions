package com.wecp.travelmanagementsystem.repository;


import com.wecp.travelmanagementsystem.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    List<Cargo> findByBusinessId(Long businessId);
    List<Cargo> findByDriverId(Long driverId);
    // Additional cargo-related query methods can be added here
}
