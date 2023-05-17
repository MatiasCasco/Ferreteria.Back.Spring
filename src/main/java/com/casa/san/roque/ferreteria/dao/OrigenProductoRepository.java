package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
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

    @Query("SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.caracteristicasProducto.id = :id")
    public List<OrigenProducto> findByIdCaracteristicasWithEmpresaAndCaracteristicasProducto(@Param("id") Long id);
    
    @Query("SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE cp.producto.id = :id")
    public List<OrigenProducto> findBYIdProductoWithEmpresaAndCaracteristicasProducto(@Param("id") Long id);
    
    @Query("SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.empresa.id = :id")
    public List<OrigenProducto> findBYIdEmpresaWithEmpresaAndCaracteristicasProducto(@Param("id") Long id);
    
    @Query("SELECT op FROM OrigenProducto op JOIN FETCH op.empresa"
            + " JOIN FETCH op.caracteristicasProducto cp JOIN FETCH cp.producto p"
            + " JOIN FETCH p.categoria"
            + " WHERE op.empresa.id = :idEmpresa and cp.producto.id = :idProducto")
    public List<OrigenProducto> findBYIdEmpresaAndIdProductoWithEmpresaAndCaracteristicasProducto(@Param("idEmpresa") Long idEmpresa, @Param("idProducto") Long idProducto);
    
}
