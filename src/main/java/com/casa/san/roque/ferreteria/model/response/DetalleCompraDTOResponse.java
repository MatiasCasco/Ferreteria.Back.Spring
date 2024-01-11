package com.casa.san.roque.ferreteria.model.response;

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
public class DetalleCompraDTOResponse {

    private Long detalleCompraId;
    
    private Long facturaCompraId;
    
    private Long caracteristicasProductoId;
    
    private int detalleCompraCantidad; 
    
    private double detalleCompraPrecioUnit;
    
    private double detalleCompraSubTotal;
}
