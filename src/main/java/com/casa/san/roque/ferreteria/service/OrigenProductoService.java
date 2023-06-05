package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTORequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface OrigenProductoService {
    
    public OrigenProducto findByOrigenProductoId(Long origenProductoId);
    
    public Page<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId, Pageable pageable);
    
    public Page<OrigenProducto> findByProductoId(Long productoId, Pageable pageable);
    
    public Page<OrigenProducto> findByEmpresaId(Long empresaId, Pageable pageable);
    
    public Page<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId, Pageable pageable);
    
    public OrigenProducto addOrigenProducto(OrigenProducto origenProducto);
    
    public OrigenProducto addOrigenProduct(OrigenProductoDTORequest origenProductoDTO);

    public List<OrigenProducto> addOrigenProducts(List<OrigenProductoDTORequest> origenProductosDTO);
    
    public List<OrigenProducto> addOrigenProductos(List<OrigenProducto> origenProductos);

    public OrigenProducto updateOrigenProducto(OrigenProducto origenProducto);

    public String deleteOrigenProducto(Long origenProductoId);
    
    public Page<OrigenProducto> getAll(Pageable pageable);
}
