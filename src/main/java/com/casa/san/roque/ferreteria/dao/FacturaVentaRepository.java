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
            + " WHERE e.id = :empleadoId AND UPPER(fv.facturaVentaEstado) like UPPER('pendiente')")
    List<FacturaVenta> FacturasPendientesBYEmpleado(@Param("empleadoId") Long empleadoId);

    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
            + " WHERE e.id = :empleadoId")
    List<FacturaVenta> findFacturasByEmpleado(@Param("empleadoId") Long empleadoId);

    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
        + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
        + " WHERE c.id = :clienteId")
    List<FacturaVenta> findFacturasByCliente(@Param("clienteId") Long clienteId);
    
    @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
        + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
        + " WHERE e.id = :empleadoId AND c.id = :clienteId")
    List<FacturaVenta> findLast(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId);
}
