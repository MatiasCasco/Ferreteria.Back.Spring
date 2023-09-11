package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Recepcion;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias Casco
 */
public interface RecepcionRepository extends JpaRepository<Recepcion, Serializable>{
    
}
