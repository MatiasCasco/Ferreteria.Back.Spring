package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface ProductoService {
    
    public List<Producto> getAll();
    
    public Producto findByProductoId(Long productoId);
    
    public List<Producto> findByMarcaId(Long marcaId);
    
    public List<Producto> findByCategoriaId(Long categoriaId);
    
    public Producto addProducto(Producto producto);

    public List<Producto> addProductos(List<Producto> productos);

    public Producto updateProducto(Producto producto);

    public String deleteProducto(Long productoId);

}
