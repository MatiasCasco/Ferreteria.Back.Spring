package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.Descuento;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.DescuentoDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterDescuento {
    
    @Autowired
    private ProductoRepository repositoryProducto;
    
    public Descuento toDescuento(DescuentoDTORequest request) {
        Producto producto = repositoryProducto.findById(request.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto cannot be null"));
        Descuento descuento = new Descuento();
        descuento.setPorcentajeDescuento(request.getPorcentajeDescuento());
        descuento.setProducto(producto);
        descuento.setRangoInferior(request.getRangoInferior());
        descuento.setRangoSuperior(request.getRangoSuperior());
        return descuento;
    }

    
}
