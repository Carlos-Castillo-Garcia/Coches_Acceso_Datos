package com.eep.Coches.ServiceImpl;

import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Repository.MarcaJPARepository;
import com.eep.Coches.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service("MarcaServiceImpl")
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    @Qualifier("MarcaJPARepository")
    private MarcaJPARepository marcaJPARepository;

    @Override
    public List<Marca> listallMarcas() {
        return marcaJPARepository.findAll();
    }
}
