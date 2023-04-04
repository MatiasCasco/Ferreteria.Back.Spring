
package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.Persona;
import java.util.List;
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

    public List<Persona> findByPersonaNombreRazonSocial(String personaNombreRazonSocial);

    public List<Persona> findAll();
}
