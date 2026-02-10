package edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.cibertec.repository.Documento;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ImpresoraServicePorConstructor {
    private Documento documento;

    public ImpresoraServicePorConstructor() {
    }

    @Autowired
    public ImpresoraServicePorConstructor(@Qualifier("documentoTexto") Documento documento) {
        this.documento = documento;
    }

    public void imprimirDocumento() {
        System.out.println(documento.imprimir());
    }
}
