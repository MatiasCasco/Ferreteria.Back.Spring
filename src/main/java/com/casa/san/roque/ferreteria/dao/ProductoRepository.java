package com.casa.san.roque.ferreteria.dao;

import com.casa.san.roque.ferreteria.model.entity.Producto;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Matias Casco
 */
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

    @Query("SELECT p FROM Producto p JOIN FETCH p.categoria")
    public List<Producto> findAll();
    
    @Query("SELECT p FROM Producto p JOIN FETCH p.categoria"
            + " JOIN FETCH p.categoria"
            + " WHERE p.id = :id")
    public Optional<Producto> findById(@Param("id") Long id);
            
    @Query("SELECT p FROM Producto p JOIN FETCH p.caracteristicas cp"
            + " JOIN FETCH cp.origenProducto o"
            + " WHERE cp.marcaId = :marcaId")
    public List<Producto> findByIdMarca(@Param("marcaId") Long marcaId);
    
    @Query("SELECT p FROM Producto p JOIN FETCH p.categoria"
            + " WHERE p.categoria.id = :id")
    public List<Producto> findByIdCategoria(@Param("id") Long id);

}
