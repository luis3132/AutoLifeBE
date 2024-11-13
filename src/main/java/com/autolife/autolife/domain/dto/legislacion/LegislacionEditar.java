package com.autolife.autolife.domain.dto.legislacion;

import java.util.Date;

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
public class LegislacionEditar {
    private Long id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String vehiculo;
    private int kilometraje;
    private int tipoLegislacion;
}
