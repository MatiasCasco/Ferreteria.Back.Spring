package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTORequest;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoService {
    
    public OrigenProducto findByOrigenProductoId(Long origenProductoId);
    
    public List<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId);
    
    public List<OrigenProducto> findByProductoId(Long productoId);
    
    public List<OrigenProducto> findByEmpresaId(Long empresaId);
    
    public List<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId);
    
    public OrigenProducto addOrigenProducto(OrigenProducto origenProducto);
    
    public OrigenProducto addOrigenProduct(OrigenProductoDTORequest origenProductoDTO);

    public List<OrigenProducto> addOrigenProducts(List<OrigenProductoDTORequest> origenProductosDTO);
    
    public List<OrigenProducto> addOrigenProductos(List<OrigenProducto> origenProductos);

    public OrigenProducto updateOrigenProducto(OrigenProducto origenProducto);

    public String deleteOrigenProducto(Long origenProductoId);
}
