package edu.cibertec.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditoriaAspects {
    @Pointcut("execution(* edu.cibertec.service.*.*(..))")
    public void main(){}

    @Before("main()")
    public void antesDeInvocarServicio(JoinPoint jp) {
        String className = jp.getSignature().getDeclaringTypeName().split("\\.")[3];
        String methodName = jp.getSignature().getName();
        //Lista los parametros de entrada del metodo
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("Parametro: " + arg);
        }
        System.out.println("Antes de invocar el metodo " + methodName + " de la clase " + className);
    }

    @After("main()")
    public void despuesDeInvocarServicio(JoinPoint jp) {
        String className = jp.getSignature().getDeclaringTypeName().split("\\.")[3];
        String methodName = jp.getSignature().getName();
        System.out.println("Despues de invocar el metodo " + methodName + " de la clase " + className);
    }

    @Around("main()")
    public Object alrededorDeInvocarServicio(ProceedingJoinPoint pjp) throws Throwable {
        // Codigo para ejecutar antes de invocar el metodo
        String className = pjp.getSignature().getDeclaringTypeName().split("\\.")[3];
        String methodName = pjp.getSignature().getName();
        System.out.println("Alrededor: antes de invocar el metodo " + methodName + " de la clase " + className);

        // Ejemplo de condicion: solo ejecutar el metodo si el nombre de la clase contiene 'service'
        boolean ejecutar = methodName.contains("imprimir")||methodName.contains("imprimirConRetorno");

         // Variable para almacenar el resultado del metodo original
        Object result = null;
        if (ejecutar) {
            // Ejecutar el metodo original y capturar el resultado
            result = pjp.proceed();
            System.out.println("Alrededor: fin de la invocacion del metodo " + methodName + " de la clase " + className);
        } else {
            // No ejecutar el metodo; opcional: devolver un valor por defecto o lanzar una excepcion
            System.out.println("Alrededor: condicion no cumplida, no se invoca el metodo " + methodName);
        }
        return result;
    }

    @AfterReturning(pointcut = "main()", returning = "result")
    public void despuesDeInvocarServicioConRetorno(JoinPoint jp, Object result){
        String className = jp.getSignature().getDeclaringTypeName().split("\\.")[3];
        String methodName = jp.getSignature().getName();
        System.out.println("Despues de invocar el metodo " + methodName + " de la clase " + className + " con retorno: " + result);
    }
}
