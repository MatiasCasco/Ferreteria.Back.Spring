package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterProducto;
import com.casa.san.roque.ferreteria.dao.CategoriaRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.dao.UnidadMedidaBaseRepository;
import com.casa.san.roque.ferreteria.model.entity.Categoria;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import com.casa.san.roque.ferreteria.model.request.ProductoDTORequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @Autowired
    private UnidadMedidaBaseRepository metricaRepository;
    
    @Autowired
    private ConverterProducto converterProducto;
    
    @Override
    public Page<Producto> getAll(Pageable pageable) {
         return repository.findAll(pageable);
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
    public Page<Producto> findByMarcaId(Long marcaId, Pageable pageable) {
        return repository.findByIdMarca(marcaId, pageable);
    }

    @Override
    public Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable) {
        return repository.findByIdCategoria(categoriaId, pageable);
    }
    
    @Transactional
    @Override
    public Producto addProducto(Producto producto) {
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getCategoriaId()).orElseThrow(() -> new IllegalArgumentException("Categoria cannot be null"));
        UnidadMedidaBase metrica = metricaRepository.findById(producto.getUnidadMedidaBase().getUnidadMedidaBaseId()).orElseThrow(() -> new IllegalArgumentException("Metrica cannot be null"));
        producto.setCategoria(categoria);
        producto.setUnidadMedidaBase(metrica);
        return repository.save(producto);

    }
    
    @Transactional
    @Override
    public List<Producto> addProductos(List<Producto> productos) {
        List<Producto> list = new ArrayList<>();
        for (Producto producto : productos) {
            Categoria categoria = categoriaRepository.findById(producto.getCategoria().getCategoriaId()).orElseThrow(() -> new IllegalArgumentException("Categoria cannot be null"));
            UnidadMedidaBase metrica = metricaRepository.findById(producto.getUnidadMedidaBase().getUnidadMedidaBaseId()).orElseThrow(() -> new IllegalArgumentException("Metrica cannot be null"));
            producto.setCategoria(categoria);
            producto.setUnidadMedidaBase(metrica);
            list.add(producto);
        }
        return repository.saveAll(list);
    }
    
    @Transactional
    @Override
    public Producto updateProducto(ProductoDTORequest productoDTORequest) {
        Producto oldProducto = null;
        Optional<Producto> optionalProducto = repository.findById(productoDTORequest.getProductoId());
        Producto converter = converterProducto.toProducto(productoDTORequest);
        if (optionalProducto.isPresent()){
            oldProducto = optionalProducto.get();
            oldProducto.setProductoId(converter.getProductoId());
            oldProducto.setCaracteristicas(converter.getCaracteristicas());
            oldProducto.setCategoria(converter.getCategoria());
            oldProducto.setProductoBoolean(converter.isProductoBoolean());
            oldProducto.setProductoIva(converter.getProductoIva());
            oldProducto.setProductoNombre(converter.getProductoNombre());
            oldProducto.setProductoPrecio(converter.getProductoPrecio());
            oldProducto.setUnidadMedidaBase(converter.getUnidadMedidaBase());
            repository.save(oldProducto);
        } else {
            return new Producto();
        }
        return oldProducto;
    }
    
    @Transactional
    @Override
    public String deleteProducto(Long productoId) {
        repository.deleteById(productoId);
        return "Eliminacion exitosa del item ".concat(productoId.toString()); 
    }
    
}
