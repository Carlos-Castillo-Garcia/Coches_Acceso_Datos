package com.eep.Coches.Service;

import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Entity.Modelo;

import java.util.List;

public interface ModeloService {
    public abstract List<Modelo> listallmodelos();
    public abstract List<Modelo> listmodelosbyMarca(Marca marca);
}
