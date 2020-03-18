package edu.eci.arsw.preparcial.persistencia;

import java.time.LocalDateTime;

public class AirportKey {
    public String data;
    public LocalDateTime tiempoDeCreacion;

    public AirportKey(String data){
        this.data = data;
        tiempoDeCreacion = LocalDateTime.now();
    }

    public String getData(){
        return data;
    }
}
