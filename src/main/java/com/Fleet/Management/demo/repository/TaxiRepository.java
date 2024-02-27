package com.Fleet.Management.demo.repository;

import com.Fleet.Management.demo.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {


}
