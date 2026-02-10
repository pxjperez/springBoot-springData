package edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.cibertec.repository.Documento;

@Service
public class ImpresoraServicePorPropiedad {
    
    @Autowired
    @Qualifier("documentoTexto")
    private Documento documento;

    public ImpresoraServicePorPropiedad() {
    }
    public ImpresoraServicePorPropiedad(Documento documento) {
        this.documento = documento;
    }

    public void imprimirDocumento() {
        System.out.println(documento.imprimir());
    }
    
    public Documento getDocumento() {
        return documento;
    }
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    
}
