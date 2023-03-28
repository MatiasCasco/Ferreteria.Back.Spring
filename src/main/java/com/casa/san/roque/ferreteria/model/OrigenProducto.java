package com.casa.san.roque.ferreteria.model;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "origen_producto")
public class OrigenProducto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "origen_producto_id")
    private Long OrigenProductoId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")       
    private Empresa empresa; 
    
    @OneToOne
    @JoinColumn(name = "caracteristicas_producto_id")
    private CaracteristicasProducto caracteristicasProducto;
    
    @Column(name = "precio_venta_proveedor")
    private double precioVentaProveedor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultima_compra")
    private Calendar ultimaCompra;
    
    @PrePersist
    public void prePersist() {
        ultimaCompra = Calendar.getInstance();
    }
} 
