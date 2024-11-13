package com.autolife.autolife.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuenosPK {
    private String vehiculo;
    private String usuario;
}
