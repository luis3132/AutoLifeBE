package com.AutoLifeBE.AutoLifeBE.domain.dto;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Roles;
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
public class RegisterDTO {
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String contrasena;
    private String email;
    private String nombreUsuario;
    private Roles roles;
}
