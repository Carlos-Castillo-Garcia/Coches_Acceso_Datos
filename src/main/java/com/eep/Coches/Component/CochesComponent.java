package com.eep.Coches.Component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("CochesComponent")
public class CochesComponent {
    private static final Log LOG = LogFactory.getLog(CochesComponent.class);

    public void addcoche(String texto){
        LOG.info(texto);
    }
    public void updatecoche(String texto){
        LOG.info(texto);
    }
    public void listcoche(String texto){
        LOG.info(texto);
    }
    public void dellcoche(String texto){
        LOG.info(texto);
    }

}
