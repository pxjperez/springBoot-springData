package edu.cibertec.service;

import org.springframework.stereotype.Service;

@Service
public class ImpresoraService {
    public void imprimir(String mensaje) {
        System.out.println("Impresora: " + mensaje);
    }
    public void descomprimir(String mensaje) {
        System.out.println("Descomprimido: " + mensaje);
    }

    public String imprimirConRetorno(String mensaje) {
        System.out.println("Impresora con retorno: " + mensaje);
        return "Retorno: " + mensaje;
    }
}
