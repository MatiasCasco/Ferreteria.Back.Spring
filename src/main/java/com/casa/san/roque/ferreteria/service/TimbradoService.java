package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Timbrado;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface TimbradoService {
    
    public Timbrado addTimbrado(Timbrado timbrado);
    
    public List<Timbrado> addTimbrados(List<Timbrado> timbrados);

    public Timbrado updateTimbrado(Timbrado timbrado);
    
    public String deleteTimbrado(Long timbradoId);
    
    public Page<Timbrado> getAll(Pageable pageable);
    
    public Timbrado findByTimbradoId(Long timbradoId);
}
