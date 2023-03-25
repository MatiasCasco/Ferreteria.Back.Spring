package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.Persona;
import com.casa.san.roque.ferreteria.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/persona")
public class PersonaContoller {
    //probar git y github
    @Autowired
    private PersonaService service;
    
    @PostMapping("/add")
    public Persona addPersona(@RequestBody Persona persona) {
        return service.addPersona(persona);
    }
    
    @PostMapping("/addPersonas")
    public List<Persona> addPersona(@RequestBody List<Persona> personas) {
        return service.addPersonas(personas);
    }
    
    @PutMapping("/update")
    public Persona updatePersona(@RequestBody Persona persona) {
        return service.updatePersona(persona);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable(name = "id", required = true) Long personaId) {
        return service.deletePersona(personaId);
    }
    
    @GetMapping("/{id}")
    public Persona findById(@PathVariable(name = "id", required = true) Long id){
        return service.getPersonaById(id);
    }
    
    @GetMapping("/all")
    public List<Persona> getAll(){
        return service.findAll();
    }
    
    @GetMapping("/persona/{ruc}")
    public Persona getPersonaByRuc(@PathVariable(name = "ruc", required = true) String ruc) {
        return service.findByRuc(ruc);
    }
    
    @GetMapping("/persona/name/{nombre}/lastName/{apellido}")
    public List<Persona> getPersonaByRuc(@PathVariable(
            name = "nombre", required = true) String nombre,
            @PathVariable(name = "apellido", required = true) String apellido) {
        return service.findByNombreAndApellido(nombre, apellido);
    }
}
