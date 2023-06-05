
package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Persona;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author Matias Casco
 */
public interface PersonaService {

    public Persona addPersona(Persona persona);

    public List<Persona> addPersonas(List<Persona> personas);

    public Persona updatePersona(Persona persona);

    public String deletePersona(Long personaId);

    public Persona getPersonaById(Long id);

    public Persona findByRucOCi(String rucOCi);

    public Page<Persona> findByPersonaNombreRazonSocial(String personaNombreRazonSocial, Pageable pageable);

    public Page<Persona> findAll(Pageable pageable);
    
    public Page<Persona> getEmpleados(Pageable pageable);
    
    public Page<Persona> getClientes(Pageable pageable);
}
