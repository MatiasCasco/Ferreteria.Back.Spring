package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTORequest;
import com.casa.san.roque.ferreteria.service.OrigenProductoService;
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
@RequestMapping("/OrigenProductoAPI")
public class OrigenProductoController {
    
    @Autowired
    private OrigenProductoService service;
    
    @PostMapping("/addOrigenProducto")
    public OrigenProducto addOrigenProducto(@RequestBody OrigenProducto origenProducto) {
        return service.addOrigenProducto(origenProducto);
    }
    
    @PostMapping("/addOrigenProductos")
    public List<OrigenProducto> addOrigenProductos(@RequestBody List<OrigenProducto> origenProductos) {
        return service.addOrigenProductos(origenProductos);
    }
    
    @PostMapping("/addOrigenProduct")
    public OrigenProducto addOrigenProduct(@RequestBody OrigenProductoDTORequest origenProductoDTO) {
        return service.addOrigenProduct(origenProductoDTO);
    }
    
    @PostMapping("/addOrigenProducts")
    public List<OrigenProducto> addOrigenProducts(@RequestBody List<OrigenProductoDTORequest> origenProductos) {
        return service.addOrigenProducts(origenProductos);
    }
    
    @PutMapping("/updateOrigenProducto")
    public OrigenProducto updateOrigenProducto(@RequestBody OrigenProducto origenProducto) {
        return service.updateOrigenProducto(origenProducto);
    }
    
    @DeleteMapping("/deleteOrigenProducto/{idOrigenProducto}")
    public String deletePersona(@PathVariable(name = "idOrigenProducto", required = true) Long idOrigenProducto) {
        return service.deleteOrigenProducto(idOrigenProducto);
    }
    
    @GetMapping("/opByOrigenProducto/{idOrigenProducto}")
    public OrigenProducto getOrigenProductoByOrigenProductoId(@PathVariable(
            name = "idOrigenProducto", required = true) Long idOrigenProducto) {
        return service.findByOrigenProductoId(idOrigenProducto);
    }
    
    @GetMapping("/opByDetalleProducto/{idDetalle}")
    public Page<OrigenProducto> getOrigenProductoByCaracteristicaId(
            @PathVariable(name = "idDetalle", required = true) Long idDetalle,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByCaracteristicasProductoId(idDetalle, PageRequest.of(page, size));
    }
    
    @GetMapping("/opByProducto/{idProducto}")
    public Page<OrigenProducto> getOrigenProductoByProductoId(
            @PathVariable(name = "idProducto", required = true) Long idProducto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByProductoId(idProducto, PageRequest.of(page, size));
    }
    
    @GetMapping("/opByEmpresa/{idEmpresa}")
    public Page<OrigenProducto> getOrigenProductoByEmpresaId(
            @PathVariable(name = "idEmpresa", required = true) Long idEmpresa,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByEmpresaId(idEmpresa, PageRequest.of(page, size));
    }
    
    @GetMapping("/opByProductoAndByEmpresa/empresa/{idEmpresa}/producto/{idProducto}")
    public Page<OrigenProducto> getOrigenProductoByEmpresaIdAndProductoId(
            @PathVariable(name = "idEmpresa", required = true) Long idEmpresa,
            @PathVariable(name = "idProducto", required = true) Long idProducto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByEmpresaIdAndProductoId(idEmpresa, idProducto, PageRequest.of(page, size));
    }
    
    @GetMapping("/all")
    public Page<OrigenProducto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAll(PageRequest.of(page, size));
    }
}
