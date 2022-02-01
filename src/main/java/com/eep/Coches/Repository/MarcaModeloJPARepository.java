package com.eep.Coches.Repository;

import com.eep.Coches.Entity.MarcaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("MarcaModeloJPARepository")
public interface MarcaModeloJPARepository  extends JpaRepository<MarcaModelo, Serializable> {
}
