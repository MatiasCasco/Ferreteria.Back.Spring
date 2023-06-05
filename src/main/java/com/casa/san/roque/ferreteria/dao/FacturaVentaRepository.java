package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import java.io.Serializable;
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
public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Serializable> {
    
    @Query(value = "SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId AND UPPER(fv.facturaVentaEstado) like UPPER('pendiente')",
            countQuery = "SELECT COUNT(fv) FROM FacturaVenta fv JOIN fv.detalleVenta dv"
            + " JOIN fv.persona c JOIN fv.empleado e"
            + " JOIN fv.caja ca"
            + " WHERE e.id = :empleadoId AND UPPER(fv.facturaVentaEstado) like UPPER('pendiente')")
    public Page<FacturaVenta> FacturasPendientesBYEmpleado(@Param("empleadoId") Long empleadoId, Pageable pageable);

    
    @Query(value = "SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId",
            countQuery = "SELECT COUNT(fv) FROM FacturaVenta fv JOIN fv.detalleVenta dv"
            + " JOIN fv.persona c JOIN fv.empleado e"
            + " JOIN fv.caja ca"
            + " WHERE e.id = :empleadoId")
    public Page<FacturaVenta> findFacturasByEmpleado(@Param("empleadoId") Long empleadoId, Pageable pageable);

    @Query(value = "SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE c.id = :clienteId",
            countQuery = "SELECT COUNT(fv) FROM FacturaVenta fv JOIN fv.detalleVenta dv"
            + " JOIN fv.persona c JOIN fv.empleado e"
            + " JOIN fv.caja ca"
            + " WHERE c.id = :clienteId")
    public Page<FacturaVenta> findFacturasByCliente(@Param("clienteId") Long clienteId, Pageable pageable);
    
    @Query(value = "SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId AND c.id = :clienteId",
            countQuery = "SELECT fv FROM FacturaVenta fv JOIN fv.detalleVenta dv"
            + " JOIN fv.persona c JOIN fv.empleado e"
            + " JOIN fv.caja ca"
            + " WHERE e.id = :empleadoId AND c.id = :clienteId")
    public Page<FacturaVenta> findLast(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId, Pageable pageable);
    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona cfindFacturasByCliente JOIN FETCH fv.empleado e"
            + " JOIN FETCH fv.caja ca"
            + " WHERE e.id = :empleadoId AND fv.facturaVentaEstado LIKE :estado")
    public FacturaVenta findLastFacturaVenta(@Param("empleadoId") Long empleadoId, @Param("estado") String estado);
    
    @Query("SELECT fv FROM FacturaVenta fv"
            + " JOIN FETCH fv.caja ca"
            + " WHERE fv.empleado.id = :empleadoId AND fv.facturaVentaEstado = 'INSERTANDO' ORDER BY fv.facturaVentaId DESC")
    public FacturaVenta findLastInsertedByEmpleadoId(@Param("empleadoId") Long empleadoId);

}
