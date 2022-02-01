package com.eep.Coches.Repository;

import com.eep.Coches.Entity.Coches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("CochesJPARepository")
public interface CochesJPARepository  extends JpaRepository<Coches, Serializable> {
}
