package com.Fleet.Management.demo.controller;


import com.Fleet.Management.demo.model.Taxi;
import com.Fleet.Management.demo.service.TaxiServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taxi")

public class TaxiController {
    private final TaxiServices taxiService;
    public TaxiController (TaxiServices taxiServices) {
        this.taxiService = taxiServices;
    }

    @Operation(summary = "Get all taxis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taxi.class)) }),
            @ApiResponse(responseCode = "400", description = "Object Taxi invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxi not found",
                    content = @Content) })

    @GetMapping("/all")
    public List<Taxi> getAllTaxis() {
        return taxiService.getAllTaxis();
    }

}




