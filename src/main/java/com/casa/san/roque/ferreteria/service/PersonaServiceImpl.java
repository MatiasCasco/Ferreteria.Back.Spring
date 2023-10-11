package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterPesona;
import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.PersonaDTORequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @Autowired
    private ConverterPesona converter;
    
    @Transactional
    @Override
    public Persona addPersona(PersonaDTORequest personaDTO) {
        Persona persona = new Persona();
        persona = converter.convertToEntity(personaDTO);
        return repository.save(persona);
    }
    
    @Transactional
    @Override
    public List<Persona> addPersonas(List<PersonaDTORequest> personasDtoList) {
        List<Persona> personas = new ArrayList<>();
        personas = converter.convertToEntityList(personasDtoList);
        return repository.saveAll(personas);
    }
    
    @Transactional
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
    
    @Transactional
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
    public Page<Persona> findByPersonaNombreRazonSocial(String personaNombreRazonSocial, Pageable pageable) {
        return repository.findByPersonaNombreRazonSocial(personaNombreRazonSocial, pageable);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Persona> getEmpleados(Pageable pageable) {
        return repository.getEmpleados(pageable);
    }

    @Override
    public Page<Persona> getClientes(Pageable pageable) {
        return repository.getClientes(pageable);
    }
}
