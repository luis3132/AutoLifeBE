package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.notificacion.NotificacionEditarDTO;
import com.autolife.autolife.domain.dto.notificacion.NotificacionNuevaDTO;
import com.autolife.autolife.persistence.entity.Notificaciones;
import com.autolife.autolife.persistence.entity.Servicios;
import com.autolife.autolife.persistence.entity.Vehiculo;
import com.autolife.autolife.persistence.repository.NotificacionesRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class NotificacionesService implements INotificacionesService {

    @Autowired
    private NotificacionesRepository notificacionesRepository;

    @Autowired
    private VehiculosService vehiculosService;

    @Autowired
    private ServiciosService serviciosService;

    @Override
    public List<Notificaciones> findByUser(String dni) {
        return notificacionesRepository.findByUser(dni);
    }

    @Override
    public List<Notificaciones> findByTaller(String dni) {
        return notificacionesRepository.findByTaller(dni);
    }

    @Override
    public Notificaciones save(NotificacionNuevaDTO notificacion) {
        return notificacionesRepository.save(convertDTOtoEntity(notificacion));
    }

    @Override
    public Notificaciones update(NotificacionEditarDTO notificacion) {
        if (notificacion.getEstado().equals("VISTA")) {
            Optional<Notificaciones> noti = notificacionesRepository.findById(notificacion.getId());
            if (noti.isPresent()) {
                return notificacionesRepository.save(convertDTOtoEntity(notificacion));
            } else
                return null;
        } else
            return null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Notificaciones> noti = notificacionesRepository.findById(id);
        if (noti.isPresent() && noti.get().getEstado().equals("VISTA")) {
            notificacionesRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    private Notificaciones convertDTOtoEntity(NotificacionNuevaDTO notificacion) {
        NotificacionEditarDTO noti = new NotificacionEditarDTO();

        noti.setTexto(notificacion.getTexto());
        noti.setEstado(notificacion.getEstado());
        noti.setFecha(notificacion.getFecha());
        noti.setUsuario(notificacion.getUsuario());
        noti.setVehiculo(notificacion.getVehiculo());
        noti.setServicio(notificacion.getServicio());
        noti.setTaller(notificacion.getTaller());

        return convertDTOtoEntity(noti);
    }

    private Notificaciones convertDTOtoEntity(NotificacionEditarDTO notificacion) {
        Notificaciones noti = new Notificaciones();

        Optional<Vehiculo> vehiculo = vehiculosService.findByNumSerie(notificacion.getVehiculo());

        Optional<Servicios> servicio = serviciosService.findById(notificacion.getServicio());

        if (vehiculo.isPresent() && servicio.isPresent()) {
            noti.setId(notificacion.getId());
            noti.setTexto(notificacion.getTexto());
            noti.setEstado(notificacion.getEstado());
            noti.setFecha(notificacion.getFecha());
            noti.setUsuario(notificacion.getUsuario());
            noti.setVehiculo(vehiculo.get());
            noti.setServicios(servicio.get());
            noti.setTaller(notificacion.getTaller());

            return noti;
        } else return null;
    }
}
