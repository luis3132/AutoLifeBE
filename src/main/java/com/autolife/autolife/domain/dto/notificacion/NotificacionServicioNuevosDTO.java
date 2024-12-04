package com.autolife.autolife.domain.dto.notificacion;

import com.autolife.autolife.domain.dto.servicios.ServicioNuevo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionServicioNuevosDTO {
    private NotificacionNuevaDTO notificacion;
    private ServicioNuevo servicio;
}
