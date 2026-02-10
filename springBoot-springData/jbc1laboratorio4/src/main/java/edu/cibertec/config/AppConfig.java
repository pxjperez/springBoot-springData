package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import edu.cibertec.utility.HolaMundo;

@Configuration
@Lazy(true)
@ComponentScan(basePackages = "edu.cibertec")
//@ComponentScan(basePackages = "edu.cibertec",lazyInit = true) //Si quiero agregar lazyInit solo para el paquete
public class AppConfig {
    @Bean
    public HolaMundo holaMundoConPropiedad(){
        HolaMundo holaMundo = new HolaMundo();
        holaMundo.setNombre("Cibertec");
        return holaMundo;
    }
}
