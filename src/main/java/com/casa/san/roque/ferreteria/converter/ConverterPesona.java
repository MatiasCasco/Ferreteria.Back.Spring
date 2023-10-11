package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.PersonaDTORequest;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterPesona {

    public PersonaDTORequest convertToDto(Persona persona) {
        PersonaDTORequest request = new PersonaDTORequest();
        request.setPersonaId(persona.getPersonaId());
        request.setPersonaNombreRazonSocial(persona.getPersonaNombreRazonSocial());
        request.setPersonaRucOCi(persona.getPersonaRucOCi());
        request.setPersonaEmail(persona.getPersonaEmail());
        request.setPersonaCelular(persona.getPersonaCelular());
        request.setPersonaDireccion(persona.getPersonaDireccion());      
        return request;
    }

    public Persona convertToEntity(PersonaDTORequest personaDto) {
        Persona persona = new Persona();
        persona.setPersonaNombreRazonSocial(personaDto.getPersonaNombreRazonSocial());
        persona.setPersonaRucOCi(personaDto.getPersonaRucOCi());
        persona.setPersonaEmail(personaDto.getPersonaEmail());
        persona.setPersonaCelular(personaDto.getPersonaCelular());
        persona.setPersonaDireccion(personaDto.getPersonaDireccion());
        return persona;
    }
    
    public List<Persona> convertToEntityList(List<PersonaDTORequest> personaDtoList) {
        return personaDtoList.stream()
            .map(this::convertToEntity)
            .collect(Collectors.toList());
    }
}
