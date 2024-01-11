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
public class DetalleCompraDTORequest {
    
    private Long detalleCompraId;
    
    private Long facturaCompraId;
    
    private Long caracteristicasProductoId;
    
    private int detalleCompraCantidad;
    
    private double detalleCompraPrecioUnit;
    
//    private Long UnidadMedidaBaseId;
//    
//    private double detalleVentaExentas;
//    
//    private double detalleVentaIva5;
//    
//    private double detalleVentaIva10;
//    
    private double detalleCompraSubTotal;
}
