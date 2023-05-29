package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Marca;
import com.casa.san.roque.ferreteria.service.MarcaService;
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
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/MarcaAPI")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @PostMapping("/addMarca")
    public Marca addMarca(@RequestBody Marca marca) {
        return service.addMarca(marca);
    }

    @PostMapping("/addMarcas")
    public List<Marca> addMarcas(@RequestBody List<Marca> marcas) {
        return service.addMarcas(marcas);
    }

    @PutMapping("/updateMarca")
    public Marca updateMarca(@RequestBody Marca marca) {
        return service.updateMarca(marca);
    }

    @DeleteMapping("/deleteMarca/{idMarca}")
    public String deleteProducto(@PathVariable(name = "idMarca", required = true) Long idMarca) {
        return service.deleteMarca(idMarca);
    }

@GetMapping("/all")
public Page<Marca> allMarca(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    return service.getAll(PageRequest.of(page, size));
}

    @GetMapping("/marcaById/{idMarca}")
    public Marca findByIdMarca(@PathVariable(name = "idMarca", required = true) Long idMarca) {
        return service.findByMarcaId(idMarca);
    }

}
