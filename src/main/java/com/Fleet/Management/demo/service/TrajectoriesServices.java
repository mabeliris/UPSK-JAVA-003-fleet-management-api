package com.Fleet.Management.demo.service;


import com.Fleet.Management.demo.model.Trajectories;
import com.Fleet.Management.demo.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TrajectoriesServices {

    private final TrajectoriesRepository trajectoriesRepository;


    @Autowired
    public TrajectoriesServices(TrajectoriesRepository trajectoriesRepository ) {
        this.trajectoriesRepository = trajectoriesRepository;

    }

    public Page<Trajectories> getAllTrajectories (Pageable pageable){

        return trajectoriesRepository.findAll(pageable);
    }

    public Page<Trajectories> findByDateAndId(int taxi_id, String dateString, Pageable pageable) {
        return trajectoriesRepository.findByTaxiIdAndDate(taxi_id, dateString, pageable);
    }


    //listar trayectorias por taxi
    public Page<Trajectories> getLastLocation(Pageable pageable) {
        return trajectoriesRepository.findLastLocation(pageable); //cambiar en el repositorio
    }
}
