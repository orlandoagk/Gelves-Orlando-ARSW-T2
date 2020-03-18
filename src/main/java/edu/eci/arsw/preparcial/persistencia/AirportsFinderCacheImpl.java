package edu.eci.arsw.preparcial.persistencia;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AirportsFinderCacheImpl implements AirportsFinderCache{
    private ConcurrentHashMap<String,AirportKey> airportsEnCache;
    public AirportsFinderCacheImpl(){
        airportsEnCache = new ConcurrentHashMap<>();
    }

    public boolean estaEnCache(String key){
        AirportKey temporal = airportsEnCache.get(key);
        if (temporal!=null && LocalDateTime.now().isAfter(temporal.tiempoDeCreacion.plusMinutes(5))){
            airportsEnCache.remove(key);
        }
        return airportsEnCache.get(key)!=null;
    }

    public void cargarCache(String key,String data){
        AirportKey temporal = new AirportKey(data);
        airportsEnCache.put(key,temporal);
    }

    public AirportKey devolverCache(String key){

        return airportsEnCache.get(key);
    }
}
