
package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Caja;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias Casco
 */
public interface CajaRepository extends JpaRepository<Caja, Serializable> {
    
//     @Query("SELECT fv FROM FacturaVenta fv JOIN FETCH fv.detalleVenta dv"
//            + " JOIN FETCH fv.persona c JOIN FETCH fv.empleado e"
//            + " JOIN FETCH fv.caja ca"
//            + " WHERE e.id = :empleadoId AND UPPER(fv.facturaVentaEstado) like UPPER('pendiente')")
//    CajaDTOResponse AperturaCaja();
    
}
