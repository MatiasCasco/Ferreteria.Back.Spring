package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.CategoriaRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.Categoria;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias Casco
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Producto> getAll() {
         return repository.findAll();
    }

    @Override
    public Producto findByProductoId(Long productoId) {
        Producto response = null;
        Optional<Producto> result = repository.findById(productoId);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
    }

    @Override
    public List<Producto> findByMarcaId(Long marcaId) {
        return repository.findByIdMarca(marcaId);
    }

    @Override
    public List<Producto> findByCategoriaId(Long categoriaId) {
        return repository.findByIdCategoria(categoriaId);
    }
    
    @Transactional
    @Override
    public Producto addProducto(Producto producto) {
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getCategoriaId()).orElse(null);
        producto.setCategoria(categoria);
        return repository.save(producto);

    }
    
    @Transactional
    @Override
    public List<Producto> addProductos(List<Producto> productos) {
        List<Producto> list = new ArrayList<>();
        for (Producto producto : productos) {
            Categoria categoria = categoriaRepository.findById(producto.getCategoria().getCategoriaId()).orElse(null);
            producto.setCategoria(categoria);
            list.add(producto);
        }
        return repository.saveAll(list);
    }
    
    @Transactional
    @Override
    public Producto updateProducto(Producto producto) {
        Producto oldProducto = null;
        Optional<Producto> optionalProducto = repository.findById(producto.getProductoId());
        if (optionalProducto.isPresent()){
            oldProducto = optionalProducto.get();
            oldProducto.setProductoId(producto.getProductoId());
            oldProducto.setCaracteristicas(producto.getCaracteristicas());
            oldProducto.setCategoria(producto.getCategoria());
            oldProducto.setProductoBoolean(producto.isProductoBoolean());
            oldProducto.setProductoIva(producto.getProductoIva());
            oldProducto.setProductoNombre(producto.getProductoNombre());
            oldProducto.setProductoPrecio(producto.getProductoPrecio());
            oldProducto.setProductoUnidadMedida(producto.getProductoUnidadMedida());
            repository.save(oldProducto);
        } else {
            return new Producto();
        }
        return producto;
    }
    
    @Transactional
    @Override
    public String deleteProducto(Long productoId) {
        repository.deleteById(productoId);
        return "Eliminacion exitosa del item ".concat(productoId.toString()); 
    }
    
}
