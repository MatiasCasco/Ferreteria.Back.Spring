package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Conversion;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface UnidadMedidaBaseService {
    
    public List<UnidadMedidaBase> getMedidasBase();
    
    public List<Conversion> getMedidasByProductoId(Long productoId);
    
    public UnidadMedidaBase getUnidadMedidaBase(Long selectedId);
    
    public Conversion getConversion(Long selectedId);
}
