package com.AutoLifeBE.AutoLifeBE.domain.dto;

import jakarta.persistence.Entity;
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
public class LoginDTO {
    private String userLogin;
    private String contrasena;
}
