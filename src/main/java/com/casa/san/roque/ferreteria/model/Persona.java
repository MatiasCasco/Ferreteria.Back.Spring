package com.casa.san.roque.ferreteria.model;

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
    
    @Column(name = "persona_nombre")
    private String personaNombre;
    
    @Column(name = "persona_apellido")
    private String personaApellido;
    
    @Column(name = "persona_rol")
    private int personaRol;
    
    @Column(name = "persona_password")
    private String personaPassword;
    
    @Column(name = "persona_nombre_razon_social")
    private String personaNombreRazonSocial;
    
    @Column(name = "persona_ruc")
    private String personaRuc;
    
    @Column(name = "persona_direccion")
    private String personaDireccion;
    
    @Column(name = "persona_celular")
    private String personaCelular;
    
    @Column(name = "persona_email")
    private String personaEmail;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FacturaVenta> facturas;
    
    private static final long serialVersionUID = 1L;
}
