package com.wecp.travelmanagementsystem.service;



import com.wecp.travelmanagementsystem.dto.CargoStatusResponse;
import com.wecp.travelmanagementsystem.entity.Cargo;
import com.wecp.travelmanagementsystem.entity.Customer;
import com.wecp.travelmanagementsystem.repository.CargoRepository;
import com.wecp.travelmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public CargoStatusResponse viewCargoStatus(Long cargoId) {
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElse(null);

        if (cargo != null) {
            // Create a response object with cargo status details
            return new CargoStatusResponse(cargo.getId(), cargo.getStatus());
        } else {
            return null;
        }
    }
}
