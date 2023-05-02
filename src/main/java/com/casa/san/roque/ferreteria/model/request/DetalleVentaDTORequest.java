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
public class DetalleVentaDTORequest {
    
    private Long facturaVentaId;
    
    private Long caracteristicasProductoId;
    
    private int detalleVentaCantidad;
    
    private String detalleVentaUnidadStock;
    
    private double detalleVentaExentas;
    
    private double detalleVentaIva5;
    
    private double detalleVentaIva10;
    
    private double detalleVentaSubTotal;
    
}
