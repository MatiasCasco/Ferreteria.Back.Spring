package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Categoria;
import com.casa.san.roque.ferreteria.model.entity.Marca;
import com.casa.san.roque.ferreteria.service.CategoriaService;
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
@RequestMapping("/CategoriaAPI")
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;
    
    @PostMapping("/addCategoria")
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return service.addCategoria(categoria);
    }

    @PostMapping("/addCategorias")
    public List<Categoria> addCategorias(@RequestBody List<Categoria> categorias) {
        return service.addCategorias(categorias);
    }

    @PutMapping("/updateCategoria")
    public Categoria updateCategoria(@RequestBody Categoria categoria) {
        return service.updateCategoria(categoria);
    }

    @DeleteMapping("/deleteCategoria/{idCategoria}")
    public String deleteCategoria(@PathVariable(name = "idCategoria", required = true) Long idCategoria) {
        return service.deleteCategoria(idCategoria);
    }

    @GetMapping("/all")
    public Page<Categoria> allCategoria(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAll(PageRequest.of(page, size));
    }

    @GetMapping("/categoriaById/{idCategoria}")
    public Categoria findByIdCategoria(@PathVariable(name = "idCategoria", required = true) Long idCategoria) {
        return service.findByCategoriaId(idCategoria);
    }
}
