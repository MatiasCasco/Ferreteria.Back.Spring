package com.casa.san.roque.ferreteria.model;

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
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "rol")
    private int rol;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "nombre_razon_social")
    private String nombreRazonSocial;
    
    @Column(name = "ruc")
    private String ruc;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "email")
    private String email;
    
    private static final long serialVersionUID = 1L;
}
