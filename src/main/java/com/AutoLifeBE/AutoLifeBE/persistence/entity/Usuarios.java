package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer roles;
    
}
