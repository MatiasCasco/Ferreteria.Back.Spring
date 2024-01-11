package com.casa.san.roque.ferreteria.model.response;

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
public class FacturaCompraDTOResponse {

    private Long facturaCompraId;
    
    private Long empresaId;
    
    private Long empleadoId;
    
    private String facturaCondicion;
    
    private Date facturaCompraFecha;
    
    private String facturaCompraNroRecibo;
    
    private double facturaCompraMontoTotal;
    
    private String facturaCompraEstado;
    
    private double facturaCompraTotalIva;
    
    private List<DetalleCompraDTOResponse> detalleCompra;
}
