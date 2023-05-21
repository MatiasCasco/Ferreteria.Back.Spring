package com.casa.san.roque.ferreteria.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
/**
 *
 * @author Matias Casco
 */
public interface CaracteristicaProductoRepository extends JpaRepository<CaracteristicaProducto, Serializable> {
    
}
