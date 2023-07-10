package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.service.EmpresaService;
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
@RequestMapping("/EmpresaAPI")
public class EmpresaController {
    
    @Autowired
    private EmpresaService service;
    
    @PostMapping("/addEmpressa")
    public Empresa addEmpresa(@RequestBody Empresa empresa) {
        return service.addEmpresa(empresa);
    }
    
    @PutMapping("/updateEmpresa")
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return service.updateEmpresa(empresa);
    }
    
    @DeleteMapping("/deleteEmpresa/{idEmpresa}")
    public String deleteEmpresa(@PathVariable(name = "idEmpresa", required = true) Long idEmpresa) {
        return service.deleteEmpresa(idEmpresa);
    }
    
    @GetMapping("/empresaById/{idEmpresa}")
    public Empresa getEmpresaByEmpresaId(@PathVariable(
            name = "idEmpresa", required = true) Long idEmpresa) {
        return service.findByEmpresaId(idEmpresa);
    }
    
    @GetMapping("/empresaByName/{nombreEmpresa}")
    public Page<Empresa> getEmpresaByEmpresaNombre(
            @PathVariable(name = "nombreEmpresa", required = true) String nombreEmpresa,
            @RequestParam(defaultValue = "0") int paga,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByEmpresaNombre(nombreEmpresa, PageRequest.of(paga, size));
    }
    
    @GetMapping("/empresaByRucOrCi/{dataRucOCi}")
    public Empresa getEmpresaByEmpresaRucOCi(@PathVariable(
            name = "dataRucOCi", required = true) String dataRucOCi) {
        return service.findByEmpresaRucOCi(dataRucOCi);
    }
    
    @GetMapping("/all")
    public Page<Empresa> allEmpresa(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAll(PageRequest.of(page, size));
    }
}
