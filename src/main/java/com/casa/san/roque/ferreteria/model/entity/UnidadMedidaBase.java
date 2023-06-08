package com.casa.san.roque.ferreteria.model.entity;

import java.io.Serializable;
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
@Table(name = "unidad_medidas_base")
public class UnidadMedidaBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "unidad_medida_base_id")
    private Long unidadMedidaBaseId;
    
    @Column(name = "unidad_medida")
    private String unidadMedida;
}
