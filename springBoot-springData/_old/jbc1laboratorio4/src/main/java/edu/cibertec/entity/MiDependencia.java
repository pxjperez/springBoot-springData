package edu.cibertec.entity;

import org.springframework.stereotype.Component;

@Component
public class MiDependencia {

        public MiDependencia() {
            System.out.println("MiDependencia: Instancia creada");
        }

        public void mostrar() {
            System.out.println("MiDependencia: Método mostrar invocado");
        }
}
