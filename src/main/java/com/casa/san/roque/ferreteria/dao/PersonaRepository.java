
package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.Persona;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias Casco
 */

public interface PersonaRepository extends JpaRepository<Persona, Serializable> {

    public Persona findByPersonaRucOCi(String rucOCi);
    
    public List<Persona> findByPersonaNombreRazonSocial(String PersonaNombreRazonSocial);
    
}
