package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Conversion;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface ConversionRepository extends JpaRepository<Conversion, Serializable>{
    
    @Query("SELECT c FROM Conversion c JOIN FETCH c.producto "
            + "WHERE c.producto.productoId = :id")
    public List<Conversion> getUnidadesMedidasBYProductoId(@Param("id") Long id);
    
}

