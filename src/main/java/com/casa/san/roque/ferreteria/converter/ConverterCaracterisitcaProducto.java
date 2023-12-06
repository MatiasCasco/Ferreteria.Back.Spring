package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.MarcaRepository;
import com.casa.san.roque.ferreteria.dao.OrigenProductoRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.Marca;
import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.CaracteristicaProductoDTORequest;
import com.casa.san.roque.ferreteria.model.response.ProductoCajaDTOResponse;
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
    
    @Autowired
    private MarcaRepository repositoryMarca;
    
    public CaracteristicaProducto toCaracteristicaProducto(CaracteristicaProductoDTORequest request) {
        CaracteristicaProducto caracteristicaProducto = new CaracteristicaProducto();
        Producto producto = repositoryProducto.findById(request.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto cannot be null"));
        OrigenProducto origenProducto = null;
        
        if (request.getOrigenProductoId() != null && request.getOrigenProductoId() > 0) {
            origenProducto = repositoryOrigenProducto.findById(request.getOrigenProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Origen Producto not found"));
        }
        
        Marca marca = repositoryMarca.findById(request.getMarcaId())
                .orElseThrow(() -> new IllegalArgumentException("Marca cannot be null"));
        
        caracteristicaProducto.setMarca(marca);
        caracteristicaProducto.setOrigenProducto(origenProducto);
        caracteristicaProducto.setProducto(producto);
        caracteristicaProducto.setProductoCosto(request.getProductoCosto());
        caracteristicaProducto.setProductoPrecio(request.getProductoPrecio());
        caracteristicaProducto.setProductoStockActual(request.getProductoStockActual());
        caracteristicaProducto.setProductoStockMax(request.getProductoStockMax());
        caracteristicaProducto.setProductoStockMin(request.getProductoStockMin());
        
        return caracteristicaProducto;
    }
    
    public ProductoCajaDTOResponse toProductoCajaDTOResponse(CaracteristicaProducto caracteristicaProducto) {
        ProductoCajaDTOResponse productoCajaDTOResponse = new ProductoCajaDTOResponse();
        productoCajaDTOResponse.setId(caracteristicaProducto.getProducto().getProductoId());
        productoCajaDTOResponse.setCategoria(caracteristicaProducto.getProducto().getCategoria().getCategoriaDescripcion());
        productoCajaDTOResponse.setIva(caracteristicaProducto.getProducto().getProductoIva());
        productoCajaDTOResponse.setMarca(caracteristicaProducto.getMarca().getMarcaDescripcion());
        productoCajaDTOResponse.setMedida(caracteristicaProducto.getProducto().getUnidadMedidaBase().getUnidadMedida());
        productoCajaDTOResponse.setNombre(caracteristicaProducto.getProducto().getProductoNombre());
        productoCajaDTOResponse.setPrecio(caracteristicaProducto.getProductoPrecio());
        return productoCajaDTOResponse;
    }
    
}
