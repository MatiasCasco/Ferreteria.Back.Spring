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
public class CajaDTOResponse {
    
    private Long cajaId;
    
    private Long cajeroId;
            
    private LocalDateTime cajaFechaApertura;

    private LocalDateTime cajaFechaCierre;
    
    private double cajaMontoApertura;
    
    private String cajaEstado;
    
}
