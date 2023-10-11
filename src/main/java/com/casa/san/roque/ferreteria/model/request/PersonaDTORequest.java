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
public class PersonaDTORequest {
    
    private Long personaId;
    private String personaNombreRazonSocial;
    private String personaRucOCi;
    private String personaDireccion;
    private String personaCelular;
    private String personaEmail;
    
}
