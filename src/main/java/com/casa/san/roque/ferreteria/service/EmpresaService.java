package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface EmpresaService {
    
    public List<Empresa> getAll();
    
    public Empresa findByEmpresaId(Long empresaId);
    
    public Empresa addEmpresa(Empresa empresa);

    public List<Empresa> addEmpresas(List<Empresa> empresas);

    public Empresa updateEmpresa(Empresa empresa);

    public String deleteEmpresa(Long empresaId);
}
