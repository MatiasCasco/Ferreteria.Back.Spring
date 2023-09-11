package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "recepciones")
public class Recepcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "recepcion_id")
    private Long recepcionId;
    
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caracteristica_producto_id")
    private CaracteristicaProducto caracteristicaProducto;
    
    @Column(name = "fecha_recepcion")
    private Date fechaRecepcion;
    
    @Column(name = "cantidad_esperada")
    private Long cantidadEsperada;
    
    @Column(name = "cantidad_recibida")
    private Long cantidadRecibida;
}
