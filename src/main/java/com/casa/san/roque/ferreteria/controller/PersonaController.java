package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.PersonaDTORequest;
import com.casa.san.roque.ferreteria.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/PersonaApi")
public class PersonaController {

    @Autowired
    private PersonaService service;
    
    @PostMapping("/addPersona")
    public Persona addPersona(@RequestBody PersonaDTORequest persona) {
        return service.addPersona(persona);
    }
    
    @PostMapping("/addPersonas")
    public List<Persona> addPersonas(@RequestBody List<PersonaDTORequest> personas) {
        return service.addPersonas(personas);
    }
    
    @PutMapping("/updatePersona")
    public Persona updatePersona(@RequestBody Persona persona) {
        return service.updatePersona(persona);
    }
    
    @DeleteMapping("/deletePerson/{id}")
    public String deletePersona(@PathVariable(name = "id", required = true) Long personaId) {
        return service.deletePersona(personaId);
    }
    
    @GetMapping("/{id}")
    public Persona findById(@PathVariable(name = "id", required = true) Long id){
        return service.getPersonaById(id);
    }
    
    @GetMapping("/empleados")
    public Page<Persona> getEmpleados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.getEmpleados(PageRequest.of(page, size));
    }
    
    @GetMapping("/clientes")
    public Page<Persona> getClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.getClientes(PageRequest.of(page, size));
    }
    
    @GetMapping("/all")
    public Page<Persona> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/persona/{rucOci}")
    public Persona getPersonaByRucOCi(@PathVariable(name = "rucOci", required = true) String rucOci) {
        return service.findByRucOCi(rucOci);
    }
    
    @GetMapping("/persona/razon_social/{razon}")
    public Page<Persona> getPersonasRazonSocial(
            @PathVariable(name = "razon", required = true) String razon,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByPersonaNombreRazonSocial(razon, PageRequest.of(page, size));
    }
}
