package com.wecp.travelmanagementsystem.service;

import com.wecp.travelmanagementsystem.entity.Cargo;
import com.wecp.travelmanagementsystem.entity.Driver;
import com.wecp.travelmanagementsystem.repository.CargoRepository;
import com.wecp.travelmanagementsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CargoRepository cargoRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Cargo> viewDriverCargos(Long driverId) {
        return cargoRepository.findByDriverId(driverId);
    }

    public boolean updateCargoStatus(Long cargoId, String newStatus) {
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new EntityNotFoundException("Cargo not found with id: " + cargoId));

        cargo.setStatus(newStatus);
        try {
            cargoRepository.save(cargo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
