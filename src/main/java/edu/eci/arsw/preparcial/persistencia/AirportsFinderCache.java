package edu.eci.arsw.preparcial.persistencia;

public interface AirportsFinderCache {
    public abstract boolean estaEnCache(String key);

    public abstract void cargarCache(String key, String data);

    public abstract AirportKey devolverCache(String key);
}
