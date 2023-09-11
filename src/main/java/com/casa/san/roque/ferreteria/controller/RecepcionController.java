package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Recepcion;
import com.casa.san.roque.ferreteria.model.request.RecepcionDTORequest;
import com.casa.san.roque.ferreteria.service.RecepcionService;
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
@RequestMapping("/RecepcionAPI")
public class RecepcionController {
    
    @Autowired
    private RecepcionService recepcionService;
    
    @PostMapping("/addRecepcion")
    public Recepcion addRecepcion(@RequestBody RecepcionDTORequest recepcion) {
        return recepcionService.addRecepcion(recepcion);
    } 
    
    @PostMapping("/addRecepciones")
    public List<Recepcion> addRecepciones(@RequestBody List<RecepcionDTORequest> recepciones) {
        return recepcionService.addRecepciones(recepciones);
    }
    
    @PutMapping("/updateRecepcion")
    public Recepcion updateRecepcion(@RequestBody RecepcionDTORequest recepcion) {
        return recepcionService.updateRecepcion(recepcion);
    }
    
    @DeleteMapping("/deleteRecepcion/{idRecepcion}")
    public String deleteRecepcion(@PathVariable(name = "idRecepcion",required = true) Long idRecepcion) {
        return recepcionService.deleteRecepcion(idRecepcion);
    }
    
    @GetMapping("/all")
    public Page<Recepcion> allRecepciones(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        return recepcionService.getAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/recepcionById/{idRecepcion}")
    public Recepcion findByIdRecepcion(@PathVariable(name = "idRecepcion", required = true) Long idRecepcion) {
        return recepcionService.findByRecepcionId(idRecepcion);
    }
}
