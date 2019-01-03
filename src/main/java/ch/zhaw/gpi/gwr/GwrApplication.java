package ch.zhaw.gpi.gwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptklasse mit Main-Methode, um die SpringBoot-Applikation zu starten
 * 
 * @author scep
 */
@SpringBootApplication
public class GwrApplication {
    
    /**
     * Main-Methode
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Startet eine Spring-Boot-Applikation basierend auf dieser Klasse
        SpringApplication.run(GwrApplication.class, args);
    }
}
