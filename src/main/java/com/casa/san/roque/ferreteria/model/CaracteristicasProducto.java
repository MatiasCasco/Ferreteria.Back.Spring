package com.casa.san.roque.ferreteria.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "caracteristicas_producto")
public class CaracteristicasProducto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "caracteristicas_producto_id")
    private Long CaracteristicasProductoId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;
    
    @OneToOne
    private OrigenProducto origenProducto;
    
    @Column(name = "marca_id")
    private int marcaId;
    
    @Column(name = "marca_nombre")
    private int marcaNombre;
    
    @Column(name = "producto_costo")
    private double productoCosto;
    
    @Column(name = "producto_precio")
    private double productoPrecio;
    
    @Column(name = "producto_stock_max")
    private int productoStockMax;
    
    @Column(name = "producto_stock_actual")
    private int productoStockActual;
    
    @Column(name = "producto_stock_min")
    private int productoStockMin;
}
