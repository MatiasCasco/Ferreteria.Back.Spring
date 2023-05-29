package com.casa.san.roque.ferreteria.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Matias Casco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaracteristicaProductoDTORequest {
    
    private Long caracteristicasProductoId;
    
    private Long productoId;
    
    private Long origenProductoId;
    
    private Long marcaId;
    
    private double productoCosto;
    
    private double productoPrecio;
    
    private int productoStockMax;
    
    private int productoStockActual;
    
    private int productoStockMin;
}
