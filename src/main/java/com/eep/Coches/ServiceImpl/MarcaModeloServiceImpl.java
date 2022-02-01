package com.eep.Coches.ServiceImpl;

import com.eep.Coches.Entity.MarcaModelo;
import com.eep.Coches.Repository.MarcaModeloJPARepository;
import com.eep.Coches.Service.MarcaModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MarcaModeloServiceImpl")
public class MarcaModeloServiceImpl implements MarcaModeloService {
    @Autowired
    @Qualifier("MarcaModeloJPARepository")
    private MarcaModeloJPARepository marcamodeloJPARepository;

    @Override
    public List<MarcaModelo> listAllMarcaModelo() {
        List<MarcaModelo> marcaModeloList = marcamodeloJPARepository.findAll();
        return null;
    }

    @Override
    public Optional<MarcaModelo> findbyid(int id) {
        return Optional.empty();
    }
}
