package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.OrigenProducto;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoRepository extends JpaRepository<OrigenProducto, Serializable> {

    List<OrigenProducto> findByCaracteristicasProducto_CaracteristicasProductoId(Long caracteristicasProductoId);

    @Query("SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.caracteristicasProducto.id = :id")
    List<OrigenProducto> findByIdWithEmpresaAndCaracteristicasProducto(@Param("id") Long id);

}
