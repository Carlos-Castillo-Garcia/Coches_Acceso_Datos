package com.eep.Coches.Component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("CochesComponent")
public class CochesComponent {
    private static final Log LOG = LogFactory.getLog(CochesComponent.class);

    public void addcoche_ok(String texto){
        LOG.info(texto);
    }
    public void updatecoche_ok(String texto){
        LOG.info(texto);
    }
    public void listcoche_ok(String texto){
        LOG.info(texto);
    }
    public void dellcoche_ok(String texto){
        LOG.info(texto);
    }

}
