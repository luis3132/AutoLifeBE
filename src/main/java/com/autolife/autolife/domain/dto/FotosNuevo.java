package com.autolife.autolife.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotosNuevo {
    private String path;
    private String vehiculo;
    private Long servicio;
    private Long accidentes;
    private String usuarios;
    private Long legislacion;
    private String piezas;
    private String partes;
}
