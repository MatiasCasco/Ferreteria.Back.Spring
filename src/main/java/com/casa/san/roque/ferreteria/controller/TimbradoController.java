package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Timbrado;
import com.casa.san.roque.ferreteria.service.TimbradoService;
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
@RequestMapping("/TimbradoPI")
public class TimbradoController {
    @Autowired
    private TimbradoService timbradoService;
    
    @PostMapping("/addTimbrado")
    public Timbrado addTimbrado(@RequestBody Timbrado timbrado) {
        return timbradoService.addTimbrado(timbrado);
    } 
    
    @PostMapping("/addTimbrados")
    public List<Timbrado> addTimbrados(@RequestBody List<Timbrado> timbrados) {
        return timbradoService.addTimbrados(timbrados);
    }
    
    @PutMapping("/updateTimbrado")
    public Timbrado updateTimbrado(@RequestBody Timbrado timbrado) {
        return timbradoService.updateTimbrado(timbrado);
    }
    
    @DeleteMapping("/deleteTimbrado/{idTimbrado}")
    public String deleteTimbrado(@PathVariable(name = "idTimbrado",required = true) Long idTimbrado) {
        return timbradoService.deleteTimbrado(idTimbrado);
    }
    
    @GetMapping("/all")
    public Page<Timbrado> allTimbrados(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        return timbradoService.getAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/recepcionById/{idTimbrado}")
    public Timbrado findByIdTimbrado(@PathVariable(name = "idTimbrado", required = true) Long idTimbrado) {
        return timbradoService.findByTimbradoId(idTimbrado);
    }
}
