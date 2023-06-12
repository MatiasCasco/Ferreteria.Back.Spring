
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
public class DetalleVentaDTOResponse {
    
    private Long detalleVentaId;
    
    private Long facturaVentaId;
    
    private Long caracteristicasProductoId;
    
    private int detalleVentaCantidad;
    
    private Long UnidadMedidaBaseId;
    
    private double detalleVentaExentas;
    
    private double detalleVentaIva5;
    
    private double detalleVentaIva10;
    
    private double detalleVentaSubTotal;
    
}
