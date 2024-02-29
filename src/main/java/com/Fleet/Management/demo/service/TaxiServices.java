package com.Fleet.Management.demo.service;

import com.Fleet.Management.demo.model.Taxi;
import com.Fleet.Management.demo.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;




//import java.util.List;
@Service
public class TaxiServices {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiServices (TaxiRepository taxiRepository) {
        this.taxiRepository= taxiRepository;
    }

    public Page<Taxi> getAllTaxis(Pageable pageable){

        return taxiRepository.findAll(pageable);
    }
}

/*Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements);

List<Product> allTenDollarProducts =
        productRepository.findAllByPrice(10, secondPageWithFiveElements);*/
