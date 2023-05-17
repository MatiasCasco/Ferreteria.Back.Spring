package com.casa.san.roque.ferreteria.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescuentoDTORequest {
    
    private Long descuentoId;
    
    private Long productoId;
    
    private Long rangoInferior;
    
    private Long rangoSuperior;
    
    private Long porcentajeDescuento;

}
