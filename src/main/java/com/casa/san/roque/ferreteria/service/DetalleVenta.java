package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.CaracteristicasProducto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_venta_id")
public class DetalleVenta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "detalle_venta_id")
    private Long detalleVentaId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristicas_producto_id")
    private CaracteristicasProducto caracteristicasProducto;
    
    @Column(name = "detalle_venta_cantidad")
    private int detalleVentaCantidad;
    
    @Column(name = "detalle_venta_unidad_stock")
    private String detalleVentaUnidadStock;
    
    @Column(name = "detalle_venta_iva")
    private double detalleVentaIva;
    
    @Column(name = "detalle_venta_sub_total")
    private double detalleVentaSubTotal;
    
    @Column(name = "detalle_venta_sub_total_iva")
    private double detalleVentaSubTotalIva;
}
