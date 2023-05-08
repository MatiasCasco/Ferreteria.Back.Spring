package com.casa.san.roque.ferreteria.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class FacturaVentaDTORequest {
       
    private String facturaCondicion;
    
    private Long clienteId;
    
    private Long empleadoId;
    
    private Long cajaId;
    
    private Date facturaVentaFecha;
    
    private String facturaVentaNroRecibo;
    
    private double facturaVentaMontoTotal;
    
    @JsonIgnore
    private String facturaVentaEstado;
    
    private double facturaVentaExentas;
    
    private double facturaVentaIva5;
    
    private double facturaVentaIva10;
    
    private double facturaVentaTotalIva;
    
    private List<DetalleVentaDTORequest> detalleVenta;
}
