package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.ConversionRepository;
import com.casa.san.roque.ferreteria.dao.UnidadMedidaBaseRepository;
import com.casa.san.roque.ferreteria.model.entity.Conversion;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class UnidadMedidaBaseServiceImpl implements UnidadMedidaBaseService {
    
    @Autowired
    private UnidadMedidaBaseRepository repository;
    
    @Autowired
    private ConversionRepository repositoryConversion;

    @Override
    public UnidadMedidaBase getUnidadMedidaBase(Long selectedId) {
        return repository.findById(selectedId).orElse(new UnidadMedidaBase());
    }
    
    @Override
    public List<UnidadMedidaBase> getMedidasBase() {
        return repository.findAll();
    }
    
    @Override
    public List<Conversion> getMedidasByProductoId(Long productoId) {
        return repositoryConversion.getUnidadesMedidasBYProductoId(productoId);
    }

    @Override
    public Conversion getConversion(Long selectedId) {
       return repositoryConversion.findById(selectedId).orElse(new Conversion());
    }

}
