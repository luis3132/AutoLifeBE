package com.autolife.autolife.domain.service;

import java.util.List;

import com.autolife.autolife.domain.dto.notificacion.NotificacionEditarDTO;
import com.autolife.autolife.domain.dto.notificacion.NotificacionNuevaDTO;
import com.autolife.autolife.domain.dto.notificacion.NotificacionServicioNuevosDTO;
import com.autolife.autolife.persistence.entity.Notificaciones;

public interface INotificacionesService {
    List<Notificaciones> findByUser(String dni);
    List<Notificaciones> findByTaller(String dni);
    Boolean saveNyS(NotificacionServicioNuevosDTO notificacion);
    Notificaciones save(NotificacionNuevaDTO notificacion);
    Notificaciones update(NotificacionEditarDTO notificacion);
    Boolean delete(Long id);
}