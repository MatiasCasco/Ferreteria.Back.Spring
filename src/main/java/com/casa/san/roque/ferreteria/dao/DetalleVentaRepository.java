package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias Casco
 */
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Serializable>{
    
}
