package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Categoria;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface CategoriaService {
    
    public List<Categoria> getAll();
    
    public Categoria findByCategoriaId(Long categoriaId);
    
    public Categoria addCategoria(Categoria categoria);

    public List<Categoria> addCategorias(List<Categoria> categorias);

    public Categoria updateCategoria(Categoria categoria);

    public String deleteCategoria(Long categoriaId);
}
