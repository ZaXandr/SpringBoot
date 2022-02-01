package com.zakharov.propertiesHW.service;

import com.zakharov.propertiesHW.entity.Departure;
import com.zakharov.propertiesHW.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartureService {

    List<Departure> departures = new ArrayList<>();

    @Autowired
    Logger logger;

    public String getMessageWithRandomNumber(){
        String message = "message with : " + new Random().nextInt(10);
        logger.logMessage(message);
        return message;
    }

    public Departure addDeparture(Departure departure){
        if(departures.stream().noneMatch(d->d.getId()==departure.getId())){
        departures.add(departure);
        }
        return departures.stream().filter(d -> d.getId() == departure.getId()).findFirst().orElse(null);
    }

    public List<Departure> getDepartures(){
        return departures;
    }

    public Departure updateDeparture(Departure departure) {

        Departure departureById = departures.stream().filter(d -> d.getId() == departure.getId()).findFirst().orElse(null);

        if(departureById == null){
            logger.logMessage("No such departure");
        } else {
            departures.remove(departureById);
            departures.add(departure);
        }

    return departures.stream().filter(d -> d.getId() == departure.getId()).findFirst().orElse(null);
    }
}
