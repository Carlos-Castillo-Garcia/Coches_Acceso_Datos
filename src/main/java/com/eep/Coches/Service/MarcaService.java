package com.eep.Coches.Service;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.Entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    public abstract List<Marca> listallMarcas();
    public abstract Optional<Marca> findbyid(Coches coches);
}
