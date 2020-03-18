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

    /**
     *
     * @param key Es el nombre del aeropuerto el cual se usará como llave para encontrarlo en el caché
     * @return Retorna si el aeropuerto ya se encuentra en caché
     */
    public boolean estaEnCache(String key){
        AirportKey temporal = airportsEnCache.get(key);
        if (temporal!=null && LocalDateTime.now().isAfter(temporal.tiempoDeCreacion.plusMinutes(5))){
            airportsEnCache.remove(key);
        }
        return airportsEnCache.get(key)!=null;
    }

    /**
     *
     * @param key Es el nombre del aeropuerto el cual se usará como llave para encontrarlo en el caché
     * @param data Es el JSON en formato de String que se guardará en caché
     */
    public void cargarCache(String key,String data){
        AirportKey temporal = new AirportKey(data);
        airportsEnCache.put(key,temporal);
    }

    /**
     *
     * @param key Es el nombre del aeropuerto el cual se usará como llave para encontrarlo en el caché
     * @return Devuelve el objeto donde esta guardado el tiempo de creación en caché y el objeto JSON mapeado en un String
     */
    public AirportKey devolverCache(String key){

        return airportsEnCache.get(key);
    }
}
