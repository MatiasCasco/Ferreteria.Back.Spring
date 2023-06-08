package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface UnidadMedidaBaseRepository extends JpaRepository<UnidadMedidaBase, Serializable>{
    
}
