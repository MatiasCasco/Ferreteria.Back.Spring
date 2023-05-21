package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.OrigenProductoRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.CaracteristicaProductoDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterCaracterisitcaProducto {
    
    @Autowired
    private ProductoRepository repositoryProducto;
    
    @Autowired
    private OrigenProductoRepository repositoryOrigenProducto;
    
    public CaracteristicaProducto toCaracteristicaProducto(CaracteristicaProductoDTORequest request) {
        CaracteristicaProducto caracteristicaProducto = new CaracteristicaProducto();
        Producto producto = repositoryProducto.findById(request.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto cannot be null"));
        OrigenProducto origenProducto = repositoryOrigenProducto.findById(request.getOrigenProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Origen Producto cannot be null"));
        caracteristicaProducto.setMarcaId(request.getMarcaId());
        caracteristicaProducto.setMarcaNombre(request.getMarcaNombre());
        caracteristicaProducto.setOrigenProducto(origenProducto);
        caracteristicaProducto.setProducto(producto);
        caracteristicaProducto.setProductoCosto(request.getProductoCosto());
        caracteristicaProducto.setProductoPrecio(request.getProductoPrecio());
        caracteristicaProducto.setProductoStockActual(request.getProductoStockActual());
        caracteristicaProducto.setProductoStockMax(request.getProductoStockMax());
        caracteristicaProducto.setProductoStockMin(request.getProductoStockMin());
        return caracteristicaProducto;
    }
    
}
