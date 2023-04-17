package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;
      
    @Override
    public Empresa addEmpresa(Empresa empresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empresa> addEmpresas(List<Empresa> empresas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteEmpresa(Long empresaId) {
        repository.deleteById(empresaId);
        return "Eliminacion exitosa del item ".concat(empresaId.toString());
    }

    @Override
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    @Override
    public Empresa findByEmpresaId(Long empresaId) {
        Empresa response = null;
        Optional<Empresa> result = repository.findById(empresaId);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
    }
    
}
