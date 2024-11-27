package com.autolife.autolife.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nombre_usuario"),
    @UniqueConstraint(columnNames = "email")
})
public class Usuarios {
    @Id
    private String dni;

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "roles", referencedColumnName = "id")
    private Roles roles;

    private String contrasena;
    private String email;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String estado;

    @OneToMany(mappedBy = "usuarios")
    private List<Fotos> fotos;
}
