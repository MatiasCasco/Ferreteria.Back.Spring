
package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.Persona;
import java.util.List;
import org.springframework.stereotype.Component;

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

    public Persona findByRuc(String ruc);

    public List<Persona> findByNombreAndApellido(String nombre, String Apellido);

    public List<Persona> findAll();
}
