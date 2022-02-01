package com.eep.Coches.Repository;


import com.eep.Coches.Entity.Marca;
import com.eep.Coches.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.io.Serializable;
import java.util.List;

@Repository("ModeloJPARepository")
public interface ModeloJPARepository extends JpaRepository<Modelo, Serializable> {
    List<Modelo> findByIdmarca(Marca id);
}
