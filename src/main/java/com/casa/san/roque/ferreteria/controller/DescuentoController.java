package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Descuento;
import com.casa.san.roque.ferreteria.model.request.DescuentoDTORequest;
import com.casa.san.roque.ferreteria.service.DescuentoService;
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
@RequestMapping("DescuentoAPI")
public class DescuentoController {
    
    @Autowired
    private DescuentoService service;
    
    @PostMapping("/addDescuento")
    public Descuento addDescuento(@RequestBody DescuentoDTORequest descuento) {
        return service.addDescuento(descuento);
    }
    
    @PostMapping("/addDescuentos")
    public List<Descuento> addDescuentos(@RequestBody List<DescuentoDTORequest> descuentos) {
        return service.addDescuentos(descuentos);

    }
    
    @PutMapping("/updateDescuento")
    public Descuento updateDescuento(@RequestBody DescuentoDTORequest descuento) {
        return service.updateDescuento(descuento);
    }
    
    @DeleteMapping("/deleteDescuento/{idDescuento}")
    public String deleteDescuento(@PathVariable(name = "idDescuento", required = true) Long idDescuento) {
        return service.deleteDescuentos(idDescuento);
    }
    
    @GetMapping("/all")
    public List<Descuento> allDescuento() {
        return service.getAll();
    }
    
    @GetMapping("/descuentoById/{idDescuento}")
    public Descuento findByIdDescuento(@PathVariable(name = "idDescuento", required = true) Long idDescuento) {
        return service.findByDescuentoId(idDescuento);
    }
        
    @GetMapping("/productoId/{idProducto}/cantidad/{cantidad}")
    public Descuento findByDescuento(
        @PathVariable(name = "idProducto", required = true) Long idProducto,
        @PathVariable(name = "cantidad", required = true) Long cantidad     
        ) {
        return service.findByDescuento(idProducto, cantidad);
    }
    
}
