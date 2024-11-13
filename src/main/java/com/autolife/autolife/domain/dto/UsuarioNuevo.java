package com.autolife.autolife.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioNuevo {
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Integer roles;
    private String contrasena;
    private String email;
    private String nombreUsuario;
}