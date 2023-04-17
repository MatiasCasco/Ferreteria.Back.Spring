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
@Table(name = "empresa_contactos")
public class EmpresaContacto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "contacto_id")
    private Long empresaContactoId;
    
    @Column(name = "contacto_nombre")
    private String contactoNombre;
    
    @Column(name = "contacto_phone")
    private String contactoPhone;
    
    @Column(name = "contacto_email")
    private String contactoEmail;
    
    private static final long serialVersionUID = 1L;
}
