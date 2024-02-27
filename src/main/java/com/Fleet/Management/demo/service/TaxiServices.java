package com.Fleet.Management.demo.service;

import com.Fleet.Management.demo.model.Taxi;
import com.Fleet.Management.demo.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaxiServices {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiServices (TaxiRepository taxiRepository) {
        this.taxiRepository= taxiRepository;
    }

    public List<Taxi> getAllTaxis(){
        return taxiRepository.findAll();
    }
}
