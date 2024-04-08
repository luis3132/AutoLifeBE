package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
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
public class Usuarios implements Serializable{
    @Id
    private String dni;
    
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String contrasena;
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles")
    private Roles roles;
    
    /**@OneToMany(mappedBy = "usuarios")
    private List<Duenos> duenos;
    
    @OneToMany(mappedBy = "usuarios")
    private List<Vehiculo> vehiculo;
    
    @OneToMany(mappedBy = "usuarios")
    private List<Fotos> fotos;**/

}
