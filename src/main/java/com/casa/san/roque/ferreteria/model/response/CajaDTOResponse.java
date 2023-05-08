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
public class CajaDTOResponse {
    
    private Long cajaId;
    
    private Long cajeroId;
    
    private double cajaSaldoInicial;
    
}
