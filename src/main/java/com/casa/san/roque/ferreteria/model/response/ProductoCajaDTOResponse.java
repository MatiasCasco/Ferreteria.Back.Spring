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
public class ProductoCajaDTOResponse {
    private Long id;
    
    private String nombre;
    
    private double iva;
    
    private String marca;
    
    private String medida;
    
    private String categoria;
    
    private double precio;
}
