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
@Table(name = "factura_compra")
public class FacturaCompra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "factura_compra_id")
    private Long facturaCompraId;
    
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Persona empleado;
    
    @Column(name = "factura_compra_condicion")
    private String facturaCondicion;
    
    @Column(name = "factura_compra_fecha")
    private Date facturaCompraFecha;
    
    @Column(name = "factura_compra_nro_recibo")
    private String facturaCompraNroRecibo;
    
    @Column(name = "factura_compra_monto_total")
    private double facturaCompraMontoTotal;
    
    @Column(name = "factura_compra_estado")
    private String facturaCompraEstado;
    
    @Column(name = "factura_compra_total_iva")
    private double facturaCompraTotalIva;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "facturaCompra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)       
    private List<DetalleCompra> detalleCompra;
}
