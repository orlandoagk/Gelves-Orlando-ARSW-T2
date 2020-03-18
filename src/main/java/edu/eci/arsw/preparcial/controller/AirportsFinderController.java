package edu.eci.arsw.preparcial.controller;

import edu.eci.arsw.preparcial.AirportsFinderApiMain;
import edu.eci.arsw.preparcial.services.AirportsFinderException;
import edu.eci.arsw.preparcial.services.AirportsFinderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/airportsfinder")
public class AirportsFinderController {

    @Autowired
    private AirportsFinderServices airportsFinderServices;



    @RequestMapping(value = "/getairportsbyname/{name}",method = RequestMethod.GET)
    public ResponseEntity<?> getAirportsByName(@PathVariable String name){
        try {
            String consulta = airportsFinderServices.getAirportsByName(name);
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } catch (AirportsFinderException ex) {
            Logger.getLogger(AirportsFinderApiMain.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
