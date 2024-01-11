package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "detalle_compra")
public class DetalleCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "detalle_compra_id")
    private Long detalleCompraId;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_compra_id")
    private FacturaCompra facturaCompra;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristicas_producto_id")
    private CaracteristicaProducto caracteristicasProducto;
    
    @Column(name = "detalle_compra_cantidad")
    private int detalleCompraCantidad; 
    
    @Column(name = "detalle_compra_precio_unit")
    private double detalleCompraPrecioUnit;
    
    @Column(name = "detalle_compra_sub_total")
    private double detalleCompraSubTotal;
}
