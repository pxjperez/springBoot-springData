package edu.cibertec.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON) //Forma recomendada para no usar codigo en duro
@DependsOn(value="holaMundoFinal")
public class HolaMundoEntity {
    private String nombre;

    public HolaMundoEntity() {
    }

    public HolaMundoEntity(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @PostConstruct
    public void iniciar(){
        System.out.println("Hola Mundo desde el metodo iniciar "+this.nombre);
    }

    @PreDestroy //Solo se ejecuta cuando el scope es singleton
    public void destruir(){
        System.out.println("Hola Mundo desde el metodo destruir "+this.nombre);
    }
}
