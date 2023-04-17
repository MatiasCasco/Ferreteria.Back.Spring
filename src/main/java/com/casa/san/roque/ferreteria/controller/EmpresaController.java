package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/EmpresaAPI")
public class EmpresaController {
    
    @Autowired
    private EmpresaService service;
    
    @DeleteMapping("/deleteEmpresa/{idEmpresa}")
    public String deleteEmpresa(@PathVariable(name = "idEmpresa", required = true) Long idEmpresa) {
        return service.deleteEmpresa(idEmpresa);
    }
    
    @GetMapping("/opByEmpresa/{idEmpresa}")
    public Empresa getEmpresaByEmpresaId(@PathVariable(
            name = "idEmpresa", required = true) Long idEmpresa) {
        return service.findByEmpresaId(idEmpresa);
    }
    
    @GetMapping("/all")
    public List<Empresa> allProducto() {
        return service.getAll();
    }
}
