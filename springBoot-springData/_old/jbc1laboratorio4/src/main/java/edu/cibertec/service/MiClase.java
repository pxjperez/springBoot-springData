package edu.cibertec.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import edu.cibertec.entity.MiDependencia;

@Component
public abstract class MiClase {
    
    public MiClase() {
        System.out.println("MiClase: Instancia creada");
    }

    public void ejecutar() {
        System.out.println("MiClase: Método ejecutar invocado");
        MiDependencia md = instanciaMiDependencia();
        md.mostrar();
    }

    @Lookup
    public abstract MiDependencia instanciaMiDependencia();
    
}
