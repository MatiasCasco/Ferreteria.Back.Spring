package com.casa.san.roque.ferreteria.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CajaDetalleDTORequest {
       
    private Long cajaId;
    
    private Long facturaVentaId;
    
    @JsonIgnore
    private LocalDateTime detalleCajaFecha;
    
    private double detalleCajaMontoTotal;
    
    private double detalleCajaMontoRecibido;
}
