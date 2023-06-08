package com.casa.san.roque.ferreteria.model.request;

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
public class ProductoDTORequest {
    
    private Long productoId;
    
    private String productoNombre;
    
    private double productoIva;
    
    private Long unidadMedidaBaseId;
    
    private boolean productoBoolean;
    
    private double productoPrecio;
    
    private Long categoriaId;

}
