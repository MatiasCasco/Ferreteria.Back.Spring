package com.casa.san.roque.ferreteria.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class FacturaVentaDTOResponse {
     
    private Long facturaVentaId;
       
    private String facturaCondicion;
    
    private Long clienteId;
    
    private Long empleadoId;
    
    private Date facturaVentaFecha;
    
    private String facturaVentaNroRecibo;
    
    private double facturaVentaMontoTotal;
    
    private String facturaVentaEstado;
    
    private double facturaVentaIva;
    
    private List<DetalleVentaDTOResponse> detalleVenta;
}
