package com.casa.san.roque.ferreteria.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Matias Casco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "producto_id")
    private Long productoId;
    
    @Column(name = "producto_name")
    private String productoNombre;
    
    @Column(name = "producto_iva")
    private double productoIva;
    
    @Column(name = "producto_unidad_medida")
    private String productoUnidadMedida;
    
    @Column(name = "producto_boolean")
    private boolean productoBoolean;
    
    @Column(name = "producto_precio")
    private double productoPrecio;
    
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<CaracteristicasProducto> caracteristicas;
}
