package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.ProductoDTORequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface ProductoService {
    
    public Page<Producto> getAll(Pageable pageable);
    
    public Producto findByProductoId(Long productoId);
    
    public Page<Producto> findByMarcaId(Long marcaId, Pageable pageable);
    
    public Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable);
    
    public Producto addProducto(Producto producto);

    public List<Producto> addProductos(List<Producto> productos);

    public Producto updateProducto(ProductoDTORequest productoDTORequest);

    public String deleteProducto(Long productoId);

}
