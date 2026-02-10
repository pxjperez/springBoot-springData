package edu.cibertec.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import edu.cibertec.config.AppConfig;
import edu.cibertec.entity.HolaMundo;
import edu.cibertec.service.ImpresoraService;

@Controller
public class MainController {

    public static void main(String[] args) {
        ApplicationContext  context =  new AnnotationConfigApplicationContext(AppConfig.class);
        HolaMundo holaMundo = context.getBean(HolaMundo.class);
        holaMundo.mensaje();

        ImpresoraService impresoraService = context.getBean(ImpresoraService.class);
        impresoraService.imprimir("Hola desde el servicio");
        impresoraService.descomprimir("Prueba");
        impresoraService.imprimirConRetorno("Hola con retorno");
    }
}
