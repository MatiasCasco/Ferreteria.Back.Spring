package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.CategoriaRepository;
import com.casa.san.roque.ferreteria.model.entity.Categoria;
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
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> getAll() {
        return repository.findAll();
    }

    @Override
    public Categoria findByCategoriaId(Long categoriaId) {
        Categoria response = null;
        Optional<Categoria> result = repository.findById(categoriaId);
        if(result.isPresent()){
            response = result.get();
        }
        return response; 
    }

    @Transactional
    @Override
    public Categoria addCategoria(Categoria categoria) {
        return repository.save(categoria);
    }
    
    @Transactional
    @Override
    public List<Categoria> addCategorias(List<Categoria> categorias) {
        return repository.saveAll(categorias);
    }

    @Transactional
    @Override
    public Categoria updateCategoria(Categoria categoria) {
        Categoria oldCategoria = null;
        Optional<Categoria> optionalCategoria = repository.findById(categoria.getCategoriaId());
        if (optionalCategoria.isPresent()){
            oldCategoria = optionalCategoria.get();
            oldCategoria.setCategoriaDescripcion(categoria.getCategoriaDescripcion());
            repository.save(oldCategoria);
        } else {
            return new Categoria();
        }
        return oldCategoria;
    }

    @Transactional
    @Override
    public String deleteCategoria(Long categoriaId) {
        repository.deleteById(categoriaId);
        return "Eliminacion exitosa del item ".concat(categoriaId.toString()); 
    }
    
   
    
}
