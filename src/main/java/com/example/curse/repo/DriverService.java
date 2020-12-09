package com.example.curse.repo;

import com.example.curse.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver findById(Long id){
        return driverRepository.getOne(id);
    }

    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

    public Driver saveDriver(Driver Driver){
        return driverRepository.save(Driver);
    }

    public void deleteById(Long id){
        driverRepository.deleteById(id);
    }


}
