package ch.zhaw.gpi.gwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptklasse für die GWR-WebService-Applikation
 * 
 * @SpringBootApplication stellt sicher, dass diese Klasse die SpringBoot-Applikation automatisch konfiguriert und vieles mehr. Details: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-using-springbootapplication-annotation
 */
@SpringBootApplication
public class GwrApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(GwrApplication.class, args);
    }
}
