package com.eep.Coches.ServiceImpl;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Repository.CochesJPARepository;
import com.eep.Coches.Service.CochesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("CochesServiceImpl")
public class CochesServiceImpl  implements CochesService {

    @Autowired
    @Qualifier("CochesJPARepository")
    private CochesJPARepository cochesJPARepository;

    @Override
    public List<Coches> listAllCoches() {
        List<Coches> coches = cochesJPARepository.findAll();
        return coches;
    }

    @Override
    public Coches addCoches(Coches coches) {
        return cochesJPARepository.save(coches);
    }

    @Override
    public int removeCoches(int id) {
        cochesJPARepository.deleteById(id);
        return 0;
    }

    @Override
    public Coches updateCoches(Coches coches) {
        cochesJPARepository.save(coches);
        return null;
    }

    @Override
    public Optional<Coches> findbyid(int id) {
        Optional<Coches> coche_id = cochesJPARepository.findById(id);
        return coche_id;
    }

    @Override
    public void delbyid(ArrayList<Integer> iterator) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < iterator.size();i++){
            int iterador = iterator.get(i);
            ids.add(cochesJPARepository.findAll().get(iterador).getId());
        }
        for (int i = 0; i < ids.size(); i++){
            cochesJPARepository.deleteById(ids.get(i));
        }
    }
}
