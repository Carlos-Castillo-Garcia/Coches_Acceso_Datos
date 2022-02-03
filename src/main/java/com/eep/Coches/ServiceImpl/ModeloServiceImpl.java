package com.eep.Coches.ServiceImpl;


import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Entity.Modelo;
import com.eep.Coches.Repository.ModeloJPARepository;
import com.eep.Coches.Service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ModeloServiceImpl")
public class ModeloServiceImpl implements ModeloService {

    @Autowired
    @Qualifier("ModeloJPARepository")
    private ModeloJPARepository modeloJPARepository;

    @Override
    public List<Modelo> listallmodelos() {
        return modeloJPARepository.findAll();
    }

    @Override
    public List<Modelo> listmodelosbyMarca(Marca marca) {
        return modeloJPARepository.findByIdmarca(marca);
    }

    @Override
    public Optional<Modelo> findbyid(int id) {
        Optional<Modelo> modelo = modeloJPARepository.findById(id);
        return modelo;
    }
}
