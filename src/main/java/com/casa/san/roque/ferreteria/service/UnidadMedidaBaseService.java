package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Conversion;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface UnidadMedidaBaseService {
    
    public Page<UnidadMedidaBase> getMedidasBase(Pageable pageable);
    
    public Page<Conversion> getMedidasByProductoId(Long productoId, Pageable pageable);
    
    public UnidadMedidaBase getUnidadMedidaBase(Long selectedId);
    
    public Conversion getConversion(Long selectedId);
}
