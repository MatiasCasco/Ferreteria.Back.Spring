package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "factura_venta")
public class FacturaVenta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "factura_venta_id")
    private Long facturaVentaId;
    
    @Column(name = "factura_condicion")
    private String facturaCondicion;
    
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Persona persona;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Persona empleado;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "caja_id")
    private Caja caja;
    
    @Column(name = "factura_venta_fecha")
    private Date facturaVentaFecha;
    
    @Column(name = "factura_venta_nro_recibo")
    private String facturaVentaNroRecibo;
    
    @Column(name = "factura_venta_monto_total")
    private double facturaVentaMontoTotal;
    
    @Column(name = "factura_venta_estado")
    private String facturaVentaEstado;
    
    @Column(name = "factura_venta_total_exentas")
    private double facturaVentaTotalExentas;
    
    @Column(name = "factura_venta_total_iva5")
    private double facturaVentaTotalIva5;
    
    @Column(name = "factura_venta_total_iva10")
    private double facturaVentaTotalIva10;
    
    @Column(name = "factura_venta_total_iva")
    private double facturaVentaTotalIva;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "facturaVenta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)       
    private List<DetalleVenta> detalleVenta;
}
