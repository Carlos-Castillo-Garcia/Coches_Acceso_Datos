package com.eep.Coches.Repository;

import com.eep.Coches.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("MarcaJPARepository")
public interface MarcaJPARepository extends JpaRepository<Marca, Serializable> {
}
