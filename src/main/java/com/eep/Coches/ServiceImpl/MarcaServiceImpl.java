package com.eep.Coches.ServiceImpl;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Repository.MarcaJPARepository;
import com.eep.Coches.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MarcaServiceImpl")
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    @Qualifier("MarcaJPARepository")
    private MarcaJPARepository marcaJPARepository;

    @Override
    public List<Marca> listallMarcas() {
        return marcaJPARepository.findAll();
    }

    @Override
    public Optional<Marca> findbyid(Coches coches) {
        int id = Integer.parseInt(coches.getMarca());
        System.out.println(id);
        Optional<Marca> marca = marcaJPARepository.findById(id);
        return marca;
    }
}
