package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.Persona;
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
            oldPersona.setPersonaCelular(persona.getPersonaCelular());
            oldPersona.setPersonaDireccion(persona.getPersonaDireccion());
            oldPersona.setPersonaEmail(persona.getPersonaEmail());
            oldPersona.setPersonaId(persona.getPersonaId());
            oldPersona.setPersonaNombreRazonSocial(persona.getPersonaNombreRazonSocial());
            oldPersona.setPersonaPassword(persona.getPersonaPassword());
            oldPersona.setPersonaRol(0);
            oldPersona.setPersonaRucOCi(persona.getPersonaRucOCi());
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
    public Persona findByRucOCi(String rucOCi) {
        return repository.findByPersonaRucOCi(rucOCi);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findByPersonaNombreRazonSocial(String personaNombreRazonSocial) {
        return repository.findByPersonaNombreRazonSocial(personaNombreRazonSocial);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Persona> getEmpleados() {
        return repository.getEmpleados();
    }

    @Override
    public List<Persona> getClientes() {
        return repository.getClientes();
    }
}
