package com.casa.san.roque.ferreteria.model.entity;

import com.casa.san.roque.ferreteria.model.entity.CaracteristicasProducto;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "detalle_venta_id")
    private Long detalleVentaId;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_venta_id")
    private FacturaVenta facturaVenta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristicas_producto_id")
    private CaracteristicasProducto caracteristicasProducto;
    
    @Column(name = "detalle_venta_cantidad")
    private int detalleVentaCantidad;
    
    @Column(name = "detalle_venta_unidad_stock")
    private String detalleVentaUnidadStock;
    
    @Column(name = "detalle_venta_exentas")
    private double detalleVentaExentas;
    
    @Column(name = "detalle_venta_iva5")
    private double detalleVentaIva5;
    
    @Column(name = "detalle_venta_iva10")
    private double detalleVentaIva10;
    
    @Column(name = "detalle_venta_sub_total")
    private double detalleVentaSubTotal;

}
