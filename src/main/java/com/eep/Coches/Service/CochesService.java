package com.eep.Coches.Service;

import com.eep.Coches.Entity.Coches;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CochesService {
    public abstract List<Coches> listAllCoches();
    public abstract Coches addCoches (Coches coches);
    public abstract int removeCoches (int id);
    public abstract Coches updateCoches (Coches coches);
    public abstract Optional<Coches> findbyid(int id);
    public abstract void delbyid (ArrayList<Integer> ids);
}
