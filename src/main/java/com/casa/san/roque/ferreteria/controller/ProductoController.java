package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.service.ProductoService;
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
    public Producto updateProducto(@RequestBody Producto producto) {
        return service.updateProducto(producto);
    }
    
    @DeleteMapping("/deleteProducto/{idProducto}")
    public String deleteProducto(@PathVariable(name = "idProducto", required = true) Long idProducto) {
        return service.deleteProducto(idProducto);
    }
    
    @GetMapping("/all")
    public List<Producto> allProducto() {
        return service.getAll();
    }
    
    @GetMapping("/productoById/{idProducto}")
    public Producto findByIdProducto(@PathVariable(name = "idProducto", required = true) Long idProducto) {
        return service.findByProductoId(idProducto);
    }
    
    @GetMapping("/productoByMarca/{idMarca}")
    public List<Producto> findByIdMarca(@PathVariable(name = "idMarca", required = true) Long idMarca) {
        return service.findByMarcaId(idMarca);
    }
    
    @GetMapping("/productoByCategoria/{idCategoria}")
    public List<Producto> findByIdCategoria(@PathVariable(name = "idCategoria", required = true) Long idCategoria) {
        return service.findByCategoriaId(idCategoria);
    }
}
