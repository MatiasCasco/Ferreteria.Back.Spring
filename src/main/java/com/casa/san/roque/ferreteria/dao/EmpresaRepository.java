package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Empresa;
import java.io.Serializable;
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
}
