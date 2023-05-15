package com.casa.san.roque.ferreteria.model.response;

import java.time.LocalDateTime;
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
public class CajaDetalleDTOResponse {
    
    private Long cajaId;
    
    private Long facturaVentaId;
    
    private LocalDateTime detalleCajaFecha;
    
    private double detalleCajaMontoTotal;
    
    private double detalleCajaMontoRecibido;
}
