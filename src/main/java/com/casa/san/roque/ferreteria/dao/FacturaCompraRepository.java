package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface FacturaCompraRepository extends JpaRepository<FacturaCompra, Serializable> {
    
    @Query(value = "SELECT fc FROM FacturaCompra fc JOIN FETCH fc.detalleCompra dc"
            + " JOIN FETCH fc.empleado em"
            + " JOIN FETCH fc.empresa e"
            + " WHERE e.id = :empresaId AND UPPER(fc.facturaCompraEstado) like UPPER('pendiente')",
            countQuery = "SELECT count(fc) FROM FacturaCompra fc JOIN fc.detalleCompra dc"
            + " JOIN fc.empleado em"
            + " JOIN fc.empresa e"
            + " WHERE e.id = :empresaId AND UPPER(fc.facturaCompraEstado) like UPPER('pendiente')")
    Page<FacturaCompra> findPendingInvoicesByEmpresa(@Param("empresaId") Long empresaId, Pageable pageable);

    @Query(value = "SELECT f FROM FacturaCompra f WHERE f.empleado.id = :empleadoId",
        countQuery = "SELECT count(f) FROM FacturaCompra f WHERE f.empleado.id = :empleadoId")
    Page<FacturaCompra> findInvoicesByEmpleado(@Param("empleadoId") Long empleadoId, Pageable pageable);

    @Query("SELECT fc FROM FacturaCompra fc"
            + " WHERE fc.empleado.id = :empleadoId AND fc.facturaCompraEstado = 'INSERTANDO' ORDER BY fc.facturaCompraId DESC")
    public FacturaCompra findLastInsertedByEmpleadoId(@Param("empleadoId") Long empleadoId);

}
