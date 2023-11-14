package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Categoria;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface CategoriaService {
    
    public Page<Categoria> getAll(Pageable pageable);
    
    public Categoria findByCategoriaId(Long categoriaId);
    
    public Categoria addCategoria(Categoria categoria);

    public List<Categoria> addCategorias(List<Categoria> categorias);

    public Categoria updateCategoria(Categoria categoria);

    public String deleteCategoria(Long categoriaId);
}
