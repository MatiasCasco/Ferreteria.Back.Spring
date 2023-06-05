package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoRepository extends JpaRepository<OrigenProducto, Serializable> {

    @Query(value = "SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.caracteristicasProducto.id = :id",
            countQuery = "SELECT COUNT(op) FROM OrigenProducto op JOIN op.empresa"
            + " JOIN op.caracteristicasProducto cp JOIN cp.producto p"
            + " JOIN p.categoria"
            + " WHERE op.caracteristicasProducto.id = :id")
    public Page<OrigenProducto> findByIdCaracteristicasWithEmpresaAndCaracteristicasProducto(@Param("id") Long id, Pageable pageable);
    
    @Query(value = "SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE cp.producto.id = :id",
            countQuery = "SELECT COUNT(op) FROM OrigenProducto op JOIN op.empresa"
            + " JOIN op.caracteristicasProducto cp JOIN cp.producto p"
            + " JOIN p.categoria"
            + " WHERE cp.producto.id = :id")
    public Page<OrigenProducto> findBYIdProductoWithEmpresaAndCaracteristicasProducto(@Param("id") Long id, Pageable pageable);
    
    @Query(value = "SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.empresa.id = :id",
            countQuery = "SELECT COUNT(op) FROM OrigenProducto op JOIN op.empresa"
            + " JOIN op.caracteristicasProducto cp JOIN cp.producto p"
            + " JOIN p.categoria"
            + " WHERE op.empresa.id = :id")
    public Page<OrigenProducto> findBYIdEmpresaWithEmpresaAndCaracteristicasProducto(@Param("id") Long id, Pageable pageable);
    
    @Query(value = "SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.empresa.id = :idEmpresa and cp.producto.id = :idProducto",
            countQuery = "SELECT COUNT(op) FROM OrigenProducto op JOIN op.empresa"
            + " JOIN op.caracteristicasProducto cp JOIN cp.producto p"
            + " JOIN p.categoria"
            + " WHERE op.empresa.id = :idEmpresa and cp.producto.id = :idProducto")
    public Page<OrigenProducto> findBYIdEmpresaAndIdProductoWithEmpresaAndCaracteristicasProducto(@Param("idEmpresa") Long idEmpresa, @Param("idProducto") Long idProducto, Pageable pageable);
    
    @Query(value = "SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria",
            countQuery = "SELECT COUNT(op) FROM OrigenProducto op JOIN op.empresa"
            + " JOIN op.caracteristicasProducto cp JOIN cp.producto p"
            + " JOIN p.categoria")
    public Page<OrigenProducto> getAll(Pageable pageable);
}
