package com.Fleet.Management.demo.repository;

import com.Fleet.Management.demo.model.Taxi;

import org.springframework.data.repository.PagingAndSortingRepository;


//import java.util.List;

public interface TaxiRepository extends PagingAndSortingRepository<Taxi, Long> {



}
