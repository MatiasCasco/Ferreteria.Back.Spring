package com.casa.san.roque.ferreteria.model;

import com.casa.san.roque.ferreteria.service.DetalleVenta;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Persona empleado;
    
    @Column(name = "factura_venta_fecha")
    private Date facturaVentaFecha;
    
    @Column(name = "factura_venta_nro_recibo")
    private String facturaVentaNroRecibo;
    
    @Column(name = "factura_venta_monto_total")
    private double facturaVentaMontoTotal;
    
    @Column(name = "factura_venta_estado")
    private String facturaVentaEstado;
    
    @Column(name = "factura_venta_iva")
    private double facturaVentaIva;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_venta_id")        
    List<DetalleVenta> detalleVenta;
}
