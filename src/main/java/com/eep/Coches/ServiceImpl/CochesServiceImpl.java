package com.eep.Coches.ServiceImpl;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Entity.Modelo;
import com.eep.Coches.Model.CocheModel;
import com.eep.Coches.Repository.CochesJPARepository;
import com.eep.Coches.Repository.MarcaJPARepository;
import com.eep.Coches.Repository.ModeloJPARepository;
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

    @Autowired
    @Qualifier("MarcaJPARepository")
    private MarcaJPARepository marcaJPARepository;

    @Autowired
    @Qualifier("ModeloJPARepository")
    private ModeloJPARepository modeloJPARepository;

    @Override
    public List<Coches> listAllCoches() {
        List<Coches> coches = cochesJPARepository.findAll();
        List<Coches> coches_marca_modelo = new ArrayList<>();
        for (int i = 0; i < coches.size(); i++){
            coches_marca_modelo.add(setter_marca_modelo(coches.get(i)));
        }
        return coches_marca_modelo;
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

    @Override
    public Coches setter_marca_modelo(Coches coches){
        Coches coche = coches;

        Optional<Marca> set_marca = marcaJPARepository.findById(Integer.parseInt(coche.getMarca()));
        Optional<Modelo> set_modelo = modeloJPARepository.findById(Integer.parseInt(coche.getModelo()));

        coche.setMarca(set_marca.get().getMarca());
        coche.setModelo(set_modelo.get().getModelo());

        return coche;
    }

    @Override
    public Coches ModelaEntityCoche(CocheModel cochemodel) {
        Coches coche = new Coches();

        coche.setId(cochemodel.getId());
        coche.setNbastidor(cochemodel.getNbastidor());
        coche.setMarca(cochemodel.getMarca());
        coche.setModelo(cochemodel.getModelo());
        coche.setMotor(cochemodel.getMotor());
        coche.setKilometros(cochemodel.getKilometros());
        coche.setModificaciones(cochemodel.getModificaciones());
        coche.setTipo_modificaciones(cochemodel.getTipo_modificaciones());

        return coche;
    }
}

