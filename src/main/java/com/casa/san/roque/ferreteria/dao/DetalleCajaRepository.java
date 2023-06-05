package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.DetalleCaja;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface DetalleCajaRepository extends JpaRepository<DetalleCaja, Serializable> {
    
//    public Optional<DetalleCaja> findByDetalleCajaId(Long id);
    
    public Page<DetalleCaja> findByCaja_CajaEstadoAndCaja_Empleado_PersonaId(
            @Param("cajaEstado") String cajaEstado,
            @Param("empleadoId") Long empleadoId,
            Pageable pageable);
    
}
