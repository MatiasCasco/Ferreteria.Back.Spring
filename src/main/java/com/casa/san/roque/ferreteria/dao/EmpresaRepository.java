package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Matias Casco
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{
    
    @Query("SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec"
            + " WHERE e.id = :empresaId")
    public Optional<Empresa> findById(Long empresaId);
    
    @Query("SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec"
            + " WHERE e.empresaNombre = :empresaNombre")
    public Optional<List<Empresa>> findByEmpresaNombre(String empresaNombre);
    
    @Query("SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec"
            + " WHERE e.empresaRuc = :empresaRucOCi")
    public Optional<Empresa> findByRucOCi(String empresaRucOCi);
}
