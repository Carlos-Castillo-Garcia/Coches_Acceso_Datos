package com.eep.Coches.Service;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Entity.MarcaModelo;

import java.util.List;
import java.util.Optional;

public interface MarcaModeloService {
    public abstract List<MarcaModelo> listAllMarcaModelo();
    public abstract Optional<MarcaModelo> findbyid(int id);
}
