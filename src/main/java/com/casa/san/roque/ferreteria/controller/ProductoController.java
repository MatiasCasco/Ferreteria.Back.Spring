package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.ProductoDTORequest;
import com.casa.san.roque.ferreteria.service.ProductoService;
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
@RequestMapping("/ProductoAPI")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @PostMapping("/addProducto")
    public Producto addProducto(@RequestBody Producto producto) {
        return service.addProducto(producto);
    }
    
    @PostMapping("/addProductos")
    public List<Producto> addProductos(@RequestBody List<Producto> productos) {
        return service.addProductos(productos);
    }
    
    @PutMapping("/updateProducto")
    public Producto updateProducto(@RequestBody ProductoDTORequest productoDTORequest) {
        return service.updateProducto(productoDTORequest);
    }
    
    @DeleteMapping("/deleteProducto/{idProducto}")
    public String deleteProducto(@PathVariable(name = "idProducto", required = true) Long idProducto) {
        return service.deleteProducto(idProducto);
    }
    
    @GetMapping("/all")
    public Page<Producto> allProducto(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        return service.getAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/productoById/{idProducto}")
    public Producto findByIdProducto(@PathVariable(name = "idProducto", required = true) Long idProducto) {
        return service.findByProductoId(idProducto);
    }
    
    @GetMapping("/productoByMarca/{idMarca}")
    public Page<Producto> findByIdMarca(
            @PathVariable(name = "idMarca", required = true) Long idMarca,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByMarcaId(idMarca, PageRequest.of(page, size));
    }
    
    @GetMapping("/productoByCategoria/{idCategoria}")
    public Page<Producto> findByIdCategoria(
            @PathVariable(name = "idCategoria", required = true) Long idCategoria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findByCategoriaId(idCategoria, PageRequest.of(page, size));
    }
}
