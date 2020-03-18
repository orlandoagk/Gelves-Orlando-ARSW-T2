package edu.eci.arsw.preparcial.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.JsonNode;
import edu.eci.arsw.preparcial.AirportsFinderApiMain;
import edu.eci.arsw.preparcial.services.AirportsFinderException;
import edu.eci.arsw.preparcial.services.AirportsFinderServices;
import org.json.JSONObject;
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

    /**
     *
     * @param name es el nombre del aeropuerto a consultar
     * @return Responde con la consulta HTTP
     */
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
