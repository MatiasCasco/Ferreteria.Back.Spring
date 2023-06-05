package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

    @Query(value = "SELECT p FROM Producto p JOIN FETCH p.categoria", 
            countQuery = "SELECT COUNT(p) FROM Producto p JOIN p.categoria")
    public Page<Producto> findAll(Pageable pageable);
    
    @Query("SELECT p FROM Producto p JOIN FETCH p.categoria"
            + " JOIN FETCH p.categoria"
            + " WHERE p.id = :id")
    public Optional<Producto> findById(@Param("id") Long id);
            
    @Query(value = "SELECT p FROM Producto p JOIN FETCH p.caracteristicas cp"
            + " JOIN FETCH cp.origenProducto o"
            + " WHERE cp.marca.marcaId = :marcaId",
            countQuery = "SELECT COUNT(p) FROM Producto p JOIN p.caracteristicas cp"
            + " JOIN cp.origenProducto o"
            + " WHERE cp.marca.marcaId = :marcaId")
    public Page<Producto> findByIdMarca(@Param("marcaId") Long marcaId, Pageable pageable);
    
    @Query(value = "SELECT p FROM Producto p JOIN FETCH p.categoria"
            + " WHERE p.categoria.id = :id",
            countQuery = "SELECT COUNT(p) FROM Producto p JOIN p.categoria"
            + " WHERE p.categoria.id = :id")
    public Page<Producto> findByIdCategoria(@Param("id") Long id, Pageable pageable);

}
