package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Serializable> {
    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId AND UPPER(fv.facturaVentaEstado) like UPPER('pendiente')")
    public List<FacturaVenta> FacturasPendientesBYEmpleado(@Param("empleadoId") Long empleadoId);

    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId")
    public List<FacturaVenta> findFacturasByEmpleado(@Param("empleadoId") Long empleadoId);

    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
        + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
        + " JOIN FETCH fv.caja ca"
        + " WHERE c.id = :clienteId")
    public List<FacturaVenta> findFacturasByCliente(@Param("clienteId") Long clienteId);
    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
        + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
        + " JOIN FETCH fv.caja ca"
        + " WHERE e.id = :empleadoId AND c.id = :clienteId")
    public List<FacturaVenta> findLast(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId);
    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
        + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
        + " JOIN FETCH fv.caja ca"
        + " WHERE e.id = :empleadoId AND fv.facturaVentaEstado LIKE :estado")
    public FacturaVenta findLastFacturaVenta(@Param("empleadoId") Long empleadoId, @Param("estado") String estado);
    
    @Query("SELECT fv FROM FacturaVenta fv"
        + " JOIN FETCH fv.caja ca"
        + " WHERE fv.empleado.id = :empleadoId AND fv.facturaVentaEstado = 'INSERTANDO' ORDER BY fv.facturaVentaId DESC")
    public FacturaVenta findLastInsertedByEmpleadoId(@Param("empleadoId") Long empleadoId);

}
