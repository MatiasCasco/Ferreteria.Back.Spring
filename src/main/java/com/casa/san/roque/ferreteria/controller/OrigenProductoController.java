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
        return service.findByCaracteristicasProductoId(id);
    }
    
    @GetMapping("/producto/id/{id}")
    public List<OrigenProducto> getOrigenProductoByProductoId(@PathVariable(
            name = "id", required = true) Long id) {
        return service.findByProductoId(id);
    }
    
    @GetMapping("/empresa/id/{id}")
    public List<OrigenProducto> getOrigenProductoByEmpresaId(@PathVariable(
            name = "id", required = true) Long id) {
        return service.findByEmpresaId(id);
    }
    
    @GetMapping("/empresa/id/{idEmpresa}/producto/id/{idProducto}")
    public List<OrigenProducto> getOrigenProductoByEmpresaIdAndProductoId(
            @PathVariable(name = "idEmpresa", required = true) Long idEmpresa,
            @PathVariable(name = "idProducto", required = true) Long idProducto) {
        return service.findByEmpresaIdAndProductoId(idEmpresa, idProducto);
    }
}
