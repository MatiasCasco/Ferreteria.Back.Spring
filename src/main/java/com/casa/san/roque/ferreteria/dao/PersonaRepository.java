
package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Persona;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Matias Casco
 */

public interface PersonaRepository extends JpaRepository<Persona, Serializable> {
    
    @Query(value = "SELECT p FROM Persona p WHERE p.personaRol = 1",
        countQuery = "SELECT COUNT(p) FROM Persona p WHERE p.personaRol = 1")
    public Page<Persona> getEmpleados(Pageable pageable);
    
    @Query(value = "SELECT p FROM Persona p WHERE p.personaRol = 2",
        countQuery = "SELECT COUNT(p) FROM Persona p WHERE p.personaRol = 2")
    public Page<Persona> getClientes(Pageable pageable);
    
    public Persona findByPersonaRucOCi(String rucOCi);
    
    public Page<Persona> findByPersonaNombreRazonSocial(String PersonaNombreRazonSocial, Pageable pageable);
    
}
