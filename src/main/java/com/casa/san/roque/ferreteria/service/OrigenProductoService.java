package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.OrigenProducto;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoService {
    
    List<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId);
    
    List<OrigenProducto> findByProductoId(Long productoId);
    
    List<OrigenProducto> findByEmpresaId(Long empresaId);
    
    List<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId);
}
