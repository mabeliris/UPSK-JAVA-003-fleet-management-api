package com.Fleet.Management.demo.service;


import com.Fleet.Management.demo.model.Trajectories;
import com.Fleet.Management.demo.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


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

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

    public Page<Trajectories> getLastLocation (int page, int size) {

        Pageable pageRequest = createPageRequestUsing(page, size);

        List<Trajectories> allCustomers = trajectoriesRepository.findLastLocation();
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allCustomers.size());

        List<Trajectories> pageContent = allCustomers.subList(start, end);

        List<Trajectories> lastLocation = trajectoriesRepository.findLastLocation();
        return new PageImpl<>( pageContent, pageRequest, lastLocation.size());
    }


}
