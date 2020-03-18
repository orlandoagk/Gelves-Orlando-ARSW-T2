package edu.eci.arsw.preparcial.services;

public class AirportsFinderException extends Exception{
    public static final String noSeEncontroElAeropuerto = "No se pudo encontrar el aeropuerto";
    public AirportsFinderException(String msj){
        super(msj);
    }
}
