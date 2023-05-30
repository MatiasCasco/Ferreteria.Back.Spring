package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{
    
    @Query("SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec"
            + " WHERE e.id = :empresaId")
    public Optional<Empresa> findById(Long empresaId);
    
    @Query(value = "SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec WHERE UPPER(e.empresaNombre) LIKE CONCAT('%', UPPER(:empresaNombre), '%')",
           countQuery = "SELECT COUNT(e) FROM Empresa e WHERE UPPER(e.empresaNombre) LIKE CONCAT('%', UPPER(:empresaNombre), '%')")
    public Page<Empresa> findByEmpresaNombre(@Param("empresaNombre") String empresaNombre, Pageable pageable);    
    
    @Query("SELECT e FROM Empresa e JOIN FETCH e.empresasContactos ec"
            + " WHERE e.empresaRuc = :empresaRucOCi")
    public Optional<Empresa> findByRucOCi(String empresaRucOCi);
}
