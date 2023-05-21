package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.EmpresaContactoRepository;
import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.model.entity.EmpresaContacto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias Casco
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;
    
    @Autowired
    private EmpresaContactoRepository repositoryContactos;
    
    @Transactional
    @Override
    public Empresa addEmpresa(Empresa empresa) {
        repositoryContactos.saveAll(empresa.getEmpresasContactos());
        repository.save(empresa);
        return empresa;
    }
    
    @Transactional
    @Override
    public List<Empresa> addEmpresas(List<Empresa> empresas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        Empresa oldEmpresa = null;
        List <EmpresaContacto> listContactos = new ArrayList<>();
        Optional<Empresa> optionalEmpresa = repository.findById(empresa.getEmpresaId());
        if (optionalEmpresa.isPresent()){
            oldEmpresa = optionalEmpresa.get();
            oldEmpresa.setEmpresaNombre(empresa.getEmpresaNombre());
            oldEmpresa.setEmpresaRuc(empresa.getEmpresaRuc());
            
            for (EmpresaContacto empresasContacto : empresa.getEmpresasContactos()) {
                EmpresaContacto oldEmpresaContacto = null;
                Optional<EmpresaContacto> optionalEmpresaContacto = repositoryContactos.findById(empresasContacto.getEmpresaContactoId());
                if(optionalEmpresaContacto.isPresent()) {
                    oldEmpresaContacto = optionalEmpresaContacto.get();
                    oldEmpresaContacto.setContactoNombre(empresasContacto.getContactoNombre());
                    oldEmpresaContacto.setContactoEmail(empresasContacto.getContactoEmail());
                    oldEmpresaContacto.setContactoPhone(empresasContacto.getContactoPhone());
                    listContactos.add(oldEmpresaContacto);
                } else {
                    repositoryContactos.save(optionalEmpresaContacto.get());
                    oldEmpresaContacto = optionalEmpresaContacto.get();
                    oldEmpresaContacto.setContactoNombre(empresasContacto.getContactoNombre());
                    oldEmpresaContacto.setContactoEmail(empresasContacto.getContactoEmail());
                    oldEmpresaContacto.setContactoPhone(empresasContacto.getContactoPhone());
                    listContactos.add(oldEmpresaContacto);
                } 
            }
            oldEmpresa.setEmpresasContactos(listContactos);
            repository.save(oldEmpresa);
        } else {
            return new Empresa();
        }
        return empresa;
    }

    @Transactional
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

    @Override
    public List<Empresa> findByEmpresaNombre(String empresaNombre) {
        List<Empresa> response = null;
        Optional<List<Empresa>> result = repository.findByEmpresaNombre(empresaNombre);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
    }

    @Override
    public Empresa findByEmpresaRucOCi(String dataRucOCI) {
       Empresa response = null;
        Optional<Empresa> result = repository.findByRucOCi(dataRucOCI);
        if(result.isPresent()){
            response = result.get();
        }
        return response; 
    }
    
}
