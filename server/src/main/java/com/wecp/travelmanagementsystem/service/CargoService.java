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
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Cargo addCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public List<Cargo> viewAllCargos() {
        return cargoRepository.findAll();
    }

    public boolean assignCargoToDriver(Long cargoId, Long driverId) {
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new EntityNotFoundException("Cargo not found with id: " + cargoId));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id: " + driverId));

        cargo.setDriver(driver);
        cargoRepository.save(cargo);
        return true;
    }
}
