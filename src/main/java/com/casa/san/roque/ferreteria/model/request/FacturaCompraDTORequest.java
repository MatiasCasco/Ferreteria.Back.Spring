package com.casa.san.roque.ferreteria.model.request;

import java.util.Date;
import java.util.List;
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
public class FacturaCompraDTORequest {
    
    private Long facturaCompraId;
    
    private String facturaCondicion;   
    
    private Long empresaId;
    
    private Long empleadoId;
    
    private Date facturaCompraFecha;
    
    private String facturaCompraNroRecibo;
    
    private double facturaCompraMontoTotal;
    
    private String facturaCompraEstado;
    
//    private double facturaVentaExentas;
//    
//    private double facturaVentaIva5;
//    
//    private double facturaVentaIva10;
    
    private double facturaCompraTotalIva;
    
    private List<DetalleCompraDTORequest> detalleCompra;
}
