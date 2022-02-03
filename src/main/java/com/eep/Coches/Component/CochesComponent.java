package com.eep.Coches.Component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("CochesComponent")
public class CochesComponent {
    private static final Log LOG = LogFactory.getLog(CochesComponent.class);

    public void Correcto(String texto){
        LOG.info(texto);
    }
    public void Error(String texto){
        LOG.error(texto);
    }

}
