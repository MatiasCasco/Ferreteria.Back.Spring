package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.OrigenProducto;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoService {
    
    List<OrigenProducto> findByCaracteristicasProducto(Long caracteristicasProductoId);
    
}
