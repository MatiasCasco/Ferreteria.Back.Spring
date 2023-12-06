package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Marca;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface MarcaService {
    
    public List<Marca> getAll();
    
    public Marca findByMarcaId(Long marcaId);
    
    public Marca addMarca(Marca marca);

    public List<Marca> addMarcas(List<Marca> marcas);

    public Marca updateMarca(Marca marca);

    public String deleteMarca(Long marcaId);
    
}
