package edu.cibertec.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.cibertec.config.AppConfig;
import edu.cibertec.entity.HolaMundoEntity;
import edu.cibertec.service.ImpresoraServicePorConstructor;
import edu.cibertec.service.ImpresoraServicePorPropiedad;
import edu.cibertec.service.MiClase;

@Controller
public class MainController {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HolaMundoEntity holaMundo = context.getBean("holaMundoEntity",HolaMundoEntity.class);
        holaMundo.setNombre("Juan Perez");
        System.out.println("Hola Mundo " + holaMundo.getNombre());

        HolaMundoEntity holaMundo2 = context.getBean("holaMundoEntity",HolaMundoEntity.class);
        System.out.println("Hola Mundo " + holaMundo2.getNombre());

        HolaMundoEntity holaMundo3 = context.getBean("holaMundoEntity",HolaMundoEntity.class);
        System.out.println("Hola Mundo " + holaMundo3.getNombre());

        System.out.println("Prueba de Inyeccion de dependencias por atributo");
        ImpresoraServicePorPropiedad impresoraService = context.getBean(ImpresoraServicePorPropiedad.class);
        impresoraService.imprimirDocumento();

        System.out.println("Prueba de Inyeccion de dependencias por constructor");
        edu.cibertec.service.ImpresoraServicePorConstructor impresoraService2 = context.getBean(ImpresoraServicePorConstructor.class);
        impresoraService2.imprimirDocumento();


        System.out.println("Configuracion con XML");
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("AppConfig.xml");
        ImpresoraServicePorConstructor impresoraServiceXml = contextXml.getBean(ImpresoraServicePorConstructor.class);
        impresoraServiceXml.imprimirDocumento();
        ImpresoraServicePorPropiedad impresoraServiceXml2 = contextXml.getBean(ImpresoraServicePorPropiedad.class);
        impresoraServiceXml2.imprimirDocumento();


        //Beans personalizados
        System.out.println("Beans personalizados");
        HolaMundoEntity holaMundoFinal = context.getBean("holaMundoFinal", HolaMundoEntity.class);
        holaMundoFinal.setNombre("JUAN");
        System.out.println("Hola Mundo " + holaMundoFinal.getNombre());

        //HolaMundoEntity holaMundoFinal2 = context.getBean("holaMundoFinal", HolaMundoEntity.class);
        //System.out.println("Hola Mundo " + holaMundoFinal2.getNombre());

        //LISTADO DE BEANS
        System.out.println("Listado de Beans");
        String[] nombresBeans = context.getBeanDefinitionNames();
        for (String nombreBean : nombresBeans) {
            System.out.println(nombreBean);     
        }

        //Destruir bean por bean
        //for (String nombreBean : nombresBeans) {
        //    Object bean = context.getBean(nombreBean);
        //    if(bean instanceof HolaMundoEntity){
        //        ((HolaMundoEntity)bean).destruir();
        //    }
        //}

        //Prueba de Inyecion de dependencias  por metodo con anotacion
        System.out.println("Prueba de Inyecion de dependencias por metodo con anotacion");
        MiClase miClase = context.getBean(MiClase.class);
        miClase.ejecutar();
        //Prueba de Inyecion de dependencias  por metodo con xml
        System.out.println("Prueba de Inyecion de dependencias por metodo con xml");
        MiClase miClaseXml = contextXml.getBean(MiClase.class);
        miClaseXml.ejecutar();
        //Destruir contexto
        ((AnnotationConfigApplicationContext)context).close();


    }

}
