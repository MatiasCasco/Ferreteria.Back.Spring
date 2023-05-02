package com.casa.san.roque.ferreteria.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
