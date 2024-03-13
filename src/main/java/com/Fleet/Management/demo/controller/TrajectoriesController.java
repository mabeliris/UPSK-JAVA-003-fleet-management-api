package com.Fleet.Management.demo.controller;
import com.Fleet.Management.demo.model.Trajectories;
import com.Fleet.Management.demo.service.TrajectoriesServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {
    @Autowired
    private final TrajectoriesServices trajectoriesService;

    public TrajectoriesController (TrajectoriesServices trajectoriesService) {
        this.trajectoriesService= trajectoriesService;
    }

    @Operation(summary = "Get-All-Trajectories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the trajectories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectories.class)) }),
            @ApiResponse(responseCode = "400", description = "Object trajectories invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Trajectories not found",
                    content = @Content)
    })


    @GetMapping("/all")
    public Page<Trajectories> getAllTrajectories (@Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                                  @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        Pageable pageable = PageRequest.of(page, size);
        return trajectoriesService.getAllTrajectories (pageable);
    }

    @Operation(summary = "Get-Locations-Of-A-Taxi-By-ID-And-Date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi locations",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectories.class)) }),

            @ApiResponse(responseCode = "404", description = "Taxi locations not found",
                    content = @Content)
    })

    //Traer por id y fecha
    @GetMapping ("byDateAndId")
    public Page<Trajectories> findByDateAndId (

            @Parameter(description = "Taxi ID") @RequestParam(name = "taxi_id") int taxi_id,
            @Parameter(description = "Date in format YYYY-MM-DD") @RequestParam (name = "date") String dateString ,
            @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return trajectoriesService.findByDateAndId (taxi_id, dateString,pageable);
    }

    //Traer ultima ubicación reportada de cada taxi
    @Operation(summary = "Get-Last-Locations ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi last locations",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectories.class)) }),

            @ApiResponse(responseCode = "404", description = "Taxi last locations not found",
                    content = @Content)
    })


    @GetMapping ("last-Location")
    public Page<Trajectories> getLastLocation (


        @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
        @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return trajectoriesService.getLastLocation(pageable);
    }


}




