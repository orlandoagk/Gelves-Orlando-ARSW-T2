package edu.eci.arsw.preparcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AirportsFinderApiMain {
    public static void main(String[] args) {
        SpringApplication.run(AirportsFinderApiMain.class,args);
    }
}
