package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.request.CaracteristicaProductoDTORequest;
import com.casa.san.roque.ferreteria.model.response.ProductoCajaDTOResponse;
import com.casa.san.roque.ferreteria.service.CaracteristicaProductoService;
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
@RequestMapping("/CaracteristicaProductoAPI")
public class CaracteristicaProductoController {
    
    @Autowired
    private CaracteristicaProductoService service;
    
    @PostMapping("/addCaracteristicaProducto")
    public CaracteristicaProducto addCaracteristicaProducto(@RequestBody CaracteristicaProductoDTORequest caracteristicaProducto) {
        return service.addCaracteristicaProducto(caracteristicaProducto);
    }
    
    @PostMapping("/addCaracteristicaProductos")
    public List<CaracteristicaProducto> addCaracteristicaProductos(@RequestBody List<CaracteristicaProductoDTORequest> caracteristicaProductos) {
        return service.addCaracteristicaProductos(caracteristicaProductos);
    }
    
    @PutMapping("/updateCaracteristicaProducto")
    public CaracteristicaProducto updateCaracteristicaProducto(@RequestBody CaracteristicaProductoDTORequest caracteristicaProducto) {
        return service.updateCaracteristicaProducto(caracteristicaProducto);
    }
    
    @DeleteMapping("/deleteCaracteristicaProducto/{id}")
    public String deleteCaracteristicaProducto(@PathVariable(name = "id", required = true) Long caracteristicaProductoId) {
        return service.deleteCaracteristicaProducto(caracteristicaProductoId);
    }
    
    @GetMapping("/{id}")
    public CaracteristicaProducto findById(@PathVariable(name = "id", required = true) Long caracteristicaProductoId){
        return service.findByCaracteristicaId(caracteristicaProductoId);
    }
    
    @GetMapping("/all")
    public Page<CaracteristicaProducto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.getAll(PageRequest.of(page, size));
    }

    @GetMapping("/fingByVar/{var}")
    public Page<ProductoCajaDTOResponse> findByVar(
            @PathVariable(name = "var", required = false) String variable,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
            ) {
        return service.findByVar(variable, PageRequest.of(page, size));
    }
}
