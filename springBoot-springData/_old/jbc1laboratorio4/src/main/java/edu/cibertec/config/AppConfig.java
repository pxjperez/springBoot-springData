package edu.cibertec.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import edu.cibertec.entity.HolaMundoEntity;

@Configuration
@ComponentScan(basePackages = "edu.cibertec",lazyInit = true)
public class AppConfig {
    @Bean
    @Scope("singleton")//Crea una unica instancia //@Scope("prototype")//Crea una nueva instancia cada vez que se solicite
    @Lazy(value = true)//No se crea la instancia hasta que se solicite
    public HolaMundoEntity holaMundoFinal(){
        return new HolaMundoEntity("Final");
    }
}