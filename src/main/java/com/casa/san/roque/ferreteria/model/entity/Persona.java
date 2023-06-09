package com.casa.san.roque.ferreteria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "persona_id")
    private Long personaId;

    @Column(name = "persona_rol")
    private int personaRol;
    
    @Column(name = "persona_password")
    private String personaPassword;
    
    @Column(name = "persona_nombre_razon_social")
    private String personaNombreRazonSocial;
    
    @Column(name = "persona_ruc_ci")
    private String personaRucOCi;
    
    @Column(name = "persona_direccion")
    private String personaDireccion;
    
    @Column(name = "persona_celular")
    private String personaCelular;
    
    @Column(name = "persona_email")
    private String personaEmail;
    
    @JsonBackReference
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FacturaVenta> facturas;
    
    private static final long serialVersionUID = 1L;
}
