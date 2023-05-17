package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Descuento;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface DescuentoRepository extends JpaRepository<Descuento, Serializable>{
    
    @Query("SELECT d FROM Descuento d " +
            " WHERE d.producto.id = :idProducto "
            + " AND :cantidad >= d.rangoInferior AND :cantidad <= d.rangoSuperior")
    public Descuento findByDescuento(@Param("idProducto") Long idProducto, @Param("cantidad") Long cantidad);
    
}
