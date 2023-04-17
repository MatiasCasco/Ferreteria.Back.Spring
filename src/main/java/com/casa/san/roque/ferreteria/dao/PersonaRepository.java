
package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Persona;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Matias Casco
 */

public interface PersonaRepository extends JpaRepository<Persona, Serializable> {
    
    @Query("SELECT p FROM Persona p"
            + " WHERE p.personaRol = 1")
    public List<Persona> getEmpleados();
    
    @Query("SELECT p FROM Persona p"
            + " WHERE p.personaRol = 2")
    public List<Persona> getClientes();
    
    public Persona findByPersonaRucOCi(String rucOCi);
    
    public List<Persona> findByPersonaNombreRazonSocial(String PersonaNombreRazonSocial);
    
}
