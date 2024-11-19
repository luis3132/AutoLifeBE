package com.autolife.autolife.domain.dto.notificacion;

import java.util.Date;

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
public class NotificacionNuevaDTO {
    private String texto;
    private String estado;
    private String usuario;
    private String vehiculo;
    private Long servicio;
    private Date fecha;
    private String taller;
}
