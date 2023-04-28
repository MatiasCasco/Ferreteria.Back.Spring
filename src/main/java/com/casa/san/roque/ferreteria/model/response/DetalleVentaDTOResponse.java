
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
    
    private String detalleVentaUnidadStock;
    
    private double detalleVentaIva;
    
    private double detalleVentaSubTotal;
    
    private double detalleVentaSubTotalIva;
    
}
