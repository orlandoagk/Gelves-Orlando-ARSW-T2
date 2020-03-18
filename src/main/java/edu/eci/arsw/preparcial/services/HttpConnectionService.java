package edu.eci.arsw.preparcial.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class HttpConnectionService {

    public String getAirportsByName(String name) throws UnirestException {
        String jsonString = null;

        HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+name)
                .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "0e72bcd144msh8951afd83016cbbp115df0jsnf8ca2e9da0ec")
                .asString();
        jsonString = response.getBody();

        return jsonString;
    }

}
