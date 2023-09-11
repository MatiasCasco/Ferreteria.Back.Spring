package com.casa.san.roque.ferreteria.model.request;

import java.util.Date;
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
public class RecepcionDTORequest {
    
    private Long recepcionId;
    
    private Long caracteristicaProductoId;
    
    private Date fechaRecepcion;
    
    private Long cantidadEsperada;
    
    private Long cantidadRecibida;
}
