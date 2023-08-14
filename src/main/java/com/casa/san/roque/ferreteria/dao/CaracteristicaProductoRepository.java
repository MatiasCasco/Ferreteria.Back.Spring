package com.casa.san.roque.ferreteria.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Matias Casco
 */
public interface CaracteristicaProductoRepository extends JpaRepository<CaracteristicaProducto, Serializable> {
    
   @Query(value = "SELECT cp FROM CaracteristicaProducto cp JOIN FETCH cp.producto p JOIN FETCH"
            + " cp.marca m JOIN p.categoria c "
            + "WHERE (:variable IS NULL OR UPPER(p.productoNombre) LIKE CONCAT('%', UPPER(:variable), '%')) OR"
            + " (:variable IS NULL OR UPPER(m.marcaDescripcion) LIKE CONCAT('%', UPPER(:variable), '%')) OR"
            + " (:variable IS NULL OR UPPER(c.categoriaDescripcion) LIKE CONCAT('%', UPPER(:variable), '%'))",
           countQuery = "SELECT cp FROM CaracteristicaProducto cp JOIN cp.producto p JOIN"
                   + " cp.marca m JOIN p.categoria c "
            + "WHERE (:variable IS NULL OR UPPER(p.productoNombre) LIKE CONCAT('%', UPPER(:variable), '%')) "
            + "OR (:variable IS NULL OR UPPER(m.marcaDescripcion) LIKE CONCAT('%', UPPER(:variable), '%')) "
            + "OR (:variable IS NULL OR UPPER(c.categoriaDescripcion) LIKE CONCAT('%', UPPER(:variable), '%'))")
    Page<CaracteristicaProducto> findByVariable(@Param("variable") String variable, Pageable pageable);
    
}
