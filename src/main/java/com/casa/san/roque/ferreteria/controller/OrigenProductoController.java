package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.OrigenProducto;
import com.casa.san.roque.ferreteria.service.OrigenProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/origenProducto")
public class OrigenProductoController {
    
    @Autowired
    private OrigenProductoService service;
    
    @GetMapping("/caracteristicasProducto/id/{id}")
    public List<OrigenProducto> getOrigenProductoByCaracteristicaId(@PathVariable(
            name = "id", required = true) Long id) {
        return service.findByCaracteristicasProducto(id);
    }
}
