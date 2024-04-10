package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuarios{
    @Id
    private String dni;
    
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String contrasena;
    private String email;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "roles", referencedColumnName = "id")
    private Roles roles;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Fotos> fotos;
}
