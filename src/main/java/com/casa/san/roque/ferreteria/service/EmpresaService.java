package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface EmpresaService {
    
    public Page<Empresa> getAll(Pageable pageble);
    
    public Empresa findByEmpresaId(Long empresaId);
    
    public Page<Empresa> findByEmpresaNombre(String empresaNombre, Pageable pageble);
    
    public Empresa findByEmpresaRucOCi(String dataRucOCI);
    
    public Empresa addEmpresa(Empresa empresa);

    public List<Empresa> addEmpresas(List<Empresa> empresas);

    public Empresa updateEmpresa(Empresa empresa);

    public String deleteEmpresa(Long empresaId);
}
