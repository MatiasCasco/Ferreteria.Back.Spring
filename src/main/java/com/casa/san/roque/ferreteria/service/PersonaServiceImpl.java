package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias Casco
 */
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository repository;
    
    @Override
    public Persona addPersona(Persona persona) {
        return repository.save(persona);
    }
    
    @Override
    public List<Persona> addPersonas(List<Persona> personas) {
        return repository.saveAll(personas);
    }
    
    @Override
    public Persona updatePersona(Persona persona) {
        Persona oldPersona = null;
        Optional<Persona> optionalPersona = repository.findById(persona.getPersonaId());
        if (optionalPersona.isPresent()){
            oldPersona = optionalPersona.get();
            oldPersona.setPersonaApellido(persona.getPersonaApellido());
            oldPersona.setPersonaCelular(persona.getPersonaCelular());
            oldPersona.setPersonaDireccion(persona.getPersonaDireccion());
            oldPersona.setPersonaEmail(persona.getPersonaEmail());
            oldPersona.setPersonaId(persona.getPersonaId());
            oldPersona.setPersonaNombre(persona.getPersonaNombre());
            oldPersona.setPersonaNombreRazonSocial(persona.getPersonaNombreRazonSocial());
            oldPersona.setPersonaPassword(persona.getPersonaPassword());
            oldPersona.setPersonaRol(0);
            oldPersona.setPersonaRuc(persona.getPersonaRuc());
            repository.save(oldPersona);
        } else {
            return new Persona();
        }
        return persona;
    }
    
    @Override
    public String deletePersona(Long personaId) {
        repository.deleteById(personaId);
        return "Eliminacion exitosa del item ".concat(personaId.toString());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Persona getPersonaById(Long id) {
        Persona response = null;
        Optional<Persona> result = repository.findById(id);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
        //return repository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Persona findByRuc(String ruc) {
        return repository.findByPersonaRuc(ruc);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findByNombreAndApellido(String nombre, String apellido) {
        return repository.findByPersonaNombreAndPersonaApellido(nombre, apellido);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return repository.findAll();
    }
}
