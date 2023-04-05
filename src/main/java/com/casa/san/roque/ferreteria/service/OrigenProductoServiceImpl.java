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
    public List<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId) {
        return repository.findByIdCaracteristicasWithEmpresaAndCaracteristicasProducto(caracteristicasProductoId);
    }

    @Override
    public List<OrigenProducto> findByProductoId(Long productoId) {
        return repository.findBYIdProductoWithEmpresaAndCaracteristicasProducto(productoId);
    }

    @Override
    public List<OrigenProducto> findByEmpresaId(Long empresaId) {
        return repository.findBYIdEmpresaWithEmpresaAndCaracteristicasProducto(empresaId);
    }

    @Override
    public List<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId) {
        return repository.findBYIdEmpresaAndIdProductoWithEmpresaAndCaracteristicasProducto(empresaId, productoId);
    }
    
}
