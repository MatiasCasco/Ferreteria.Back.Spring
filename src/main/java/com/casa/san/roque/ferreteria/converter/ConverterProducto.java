package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.CategoriaRepository;
import com.casa.san.roque.ferreteria.dao.UnidadMedidaBaseRepository;
import com.casa.san.roque.ferreteria.model.entity.Categoria;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import com.casa.san.roque.ferreteria.model.request.ProductoDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterProducto {
    
    @Autowired
    private CategoriaRepository repositoryCategoria;
    
    @Autowired
    private UnidadMedidaBaseRepository repositoryUnidadMedida;
    
    public Producto toProducto(ProductoDTORequest request) {
        Producto producto = new Producto();
        Categoria categoria = repositoryCategoria.findById(request.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria cannot be null"));
        UnidadMedidaBase unidadMedidaBase = repositoryUnidadMedida.findById(request.getUnidadMedidaBaseId())
            .orElseThrow(() -> new IllegalArgumentException("Unidad Medida Base cannot be null"));
        producto.setCategoria(categoria);
        producto.setProductoBoolean(request.isProductoBoolean());
        producto.setProductoId(request.getProductoId());
        producto.setProductoIva(request.getProductoIva());
        producto.setProductoNombre(request.getProductoNombre());
        producto.setProductoPrecio(request.getProductoPrecio());
        producto.setUnidadMedidaBase(unidadMedidaBase);
        return producto;
    }    
   
}
