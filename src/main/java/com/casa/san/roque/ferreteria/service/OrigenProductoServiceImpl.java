package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.OrigenProductoRepository;
import com.casa.san.roque.ferreteria.model.OrigenProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class OrigenProductoServiceImpl implements OrigenProductoService{
    
    @Autowired
    private OrigenProductoRepository repository;
    
    @Override
    public List<OrigenProducto> findByCaracteristicasProducto(Long caracteristicasProductoId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return repository.findByCaracteristicasProducto_CaracteristicasProductoId(caracteristicasProductoId);
        return repository.findByIdWithEmpresaAndCaracteristicasProducto(caracteristicasProductoId);
    }
    
}
