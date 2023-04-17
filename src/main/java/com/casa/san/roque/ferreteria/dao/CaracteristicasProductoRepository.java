package com.casa.san.roque.ferreteria.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicasProducto;
/**
 *
 * @author Matias Casco
 */
public interface CaracteristicasProductoRepository extends JpaRepository<CaracteristicasProducto, Serializable> {
    
}
