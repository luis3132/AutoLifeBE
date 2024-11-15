package com.autolife.autolife.domain.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String nombreUsuario;
    private String contrasena;
}
