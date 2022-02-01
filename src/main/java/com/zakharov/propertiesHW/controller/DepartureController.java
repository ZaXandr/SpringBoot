package com.zakharov.propertiesHW.controller;


import com.zakharov.propertiesHW.entity.Departure;
import com.zakharov.propertiesHW.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartureController {

    @Autowired
    DepartureService departureService;

    @GetMapping(value = "/index")
    public String hello(){
        return departureService.getMessageWithRandomNumber();
    }

    @GetMapping("/departures")
    public List<Departure> getDepartures(){
        return departureService.getDepartures();
    }

    @PostMapping("/departure")
    public Departure addDeparture(@RequestBody Departure departure){
        return departureService.addDeparture(departure);
    }

    @PutMapping("/departure/{id}")
    public Departure updateDeparture(@RequestBody Departure departure){
        return departureService.updateDeparture(departure);
    }


}
