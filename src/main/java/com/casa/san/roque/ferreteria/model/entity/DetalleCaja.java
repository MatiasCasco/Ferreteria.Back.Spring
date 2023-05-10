package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "detalle_caja")
public class DetalleCaja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "detalle_caja_id")
    private Long detalleCajaId;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caja_id")
    private Caja caja;
    
    @OneToOne
    @JoinColumn(name = "factura_venta_id")
    private FacturaVenta facturaVenta;
    
    @Column(name = "detalle_caja_fecha")
    private LocalDateTime detalleCajaFecha;
    
    @Column(name = "detalle_caja_monto_total")
    private double detalleCajaMontoTotal;
    
    @Column(name = "detalle_caja_monto_recibido")
    private double detalleCajaMontoRecibido;
    
}
