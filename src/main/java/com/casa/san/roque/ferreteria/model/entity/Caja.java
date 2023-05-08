package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Caja")
public class Caja implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "caja_id")
    private Long cajaId;
    
    @Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "caja_fecha_apertura")
    private Date cajaFechaApertura;

    @Column(name = "caja_fecha_cierre")
    private Date cajaFechaCierre;
    
    @Column(name = "caja_exentas")
    private double cajaExentas;
    
    @Column(name = "caja_total_iva5")
    private double cajaTotalIva5;
    
    @Column(name = "caja_total_iva10")
    private double cajaTotalIva10;
    
    @Column(name = "caja_monto_apertura")
    private double cajaMontoApertura;
    
    @Column(name = "caja_monto_cierre")
    private double cajaMontoCierre;
    
    @Column(name = "caja_estado")
    private String cajaEstado;
    
    @JsonBackReference
    @OneToMany(mappedBy = "caja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FacturaVenta> facturas;

}
