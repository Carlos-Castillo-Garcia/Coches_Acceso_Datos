package com.eep.Coches.Service;

import com.eep.Coches.Entity.Coches;

import java.util.List;

public interface CochesService {
    public abstract List<Coches> listAllCoches();
    public abstract Coches addCoches (Coches coches);
    public abstract int removeCoches (int id);
    public abstract Coches updateCoches (Coches coches);
}
