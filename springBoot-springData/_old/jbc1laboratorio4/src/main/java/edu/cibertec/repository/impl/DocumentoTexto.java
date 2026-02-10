package edu.cibertec.repository.impl;

import org.springframework.stereotype.Repository;
import edu.cibertec.repository.Documento;


@Repository
public class DocumentoTexto implements Documento {
    @Override
    public String imprimir() {
        return "Hola Mundo desde Documento Texto";
    }
    
}
