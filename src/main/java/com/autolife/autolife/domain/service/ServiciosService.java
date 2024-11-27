package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.servicios.ServicioEditar;
import com.autolife.autolife.domain.dto.servicios.ServicioNuevo;
import com.autolife.autolife.persistence.entity.Servicios;
import com.autolife.autolife.persistence.entity.TipoServicio;
import com.autolife.autolife.persistence.entity.Usuarios;
import com.autolife.autolife.persistence.entity.Vehiculo;
import com.autolife.autolife.persistence.repository.ServiciosRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiciosService implements IServiciosService {
    
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Autowired
    private TipoServicioService tipoServicioService;

    @Autowired
    private VehiculosService vehiculosService;

    @Autowired
    private UsuariosService usuariosService;

    @Override
    public Optional<Servicios> findById(Long id) {
        return serviciosRepository.findById(id);
    }

    @Override
    public List<Servicios> saveAll(List<ServicioNuevo> servicios) {
        List<Servicios> serviciosEntity = new ArrayList<>();
        for (ServicioNuevo servicioNuevo : servicios) {
            Servicios servicio = convertDTOtoEntity(servicioNuevo);
            serviciosEntity.add(servicio);
        }
        return serviciosRepository.saveAll(serviciosEntity);
    }

    @Override
    public Servicios update(ServicioEditar servicio) {
        Optional<Servicios> servicioEntity = serviciosRepository.findById(servicio.getId());
        if (servicioEntity.isPresent()) {
            return serviciosRepository.save(convertDTOtoEntity(servicio));
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Servicios> servicio = serviciosRepository.findById(id);
        if (servicio.isPresent() && (servicio.get().getEstado().equals("PENDIENTE") || servicio.get().getEstado().equals("NOACEPTADO"))) {
            serviciosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Servicios convertDTOtoEntity(ServicioNuevo servicio){
        ServicioEditar servicioEditar = new ServicioEditar();
        servicioEditar.setCostoServicio(servicio.getCostoServicio());
        servicioEditar.setDescripcion(servicio.getDescripcion());
        servicioEditar.setFecha(servicio.getFecha());
        servicioEditar.setFechaProximo(servicio.getFechaProximo());
        servicioEditar.setKilometraje(servicio.getKilometraje());
        servicioEditar.setTipoServicio(servicio.getTipoServicio());
        servicioEditar.setVehiculo(servicio.getVehiculo());
        servicioEditar.setEstado(servicio.getEstado());
        servicioEditar.setMecanico(servicio.getMecanico());
        return convertDTOtoEntity(servicioEditar);
    }

    private Servicios convertDTOtoEntity(ServicioEditar servicioNuevo) {
        Servicios servicio = new Servicios();
        
        Optional<TipoServicio> tipoServicio = tipoServicioService.findById(servicioNuevo.getTipoServicio());

        Optional<Vehiculo> vehiculo = vehiculosService.findByNumSerie(servicioNuevo.getVehiculo());

        Optional<Usuarios> mecanico = usuariosService.findByUsuario(servicioNuevo.getMecanico());

        if (tipoServicio.isPresent() && vehiculo.isPresent() && mecanico.isPresent()) {
            servicio.setId(servicioNuevo.getId());
            servicio.setDescripcion(servicioNuevo.getDescripcion());
            servicio.setCostoServicio(servicioNuevo.getCostoServicio());
            servicio.setFecha(servicioNuevo.getFecha());
            servicio.setFechaProximo(servicioNuevo.getFechaProximo());
            servicio.setKilometraje(servicioNuevo.getKilometraje());
            servicio.setVehiculo(vehiculo.get());
            servicio.setTipoServicio(tipoServicio.get());
            servicio.setMecanico(mecanico.get());
            servicio.setEstado(servicioNuevo.getEstado());
            return servicio;
        }
        return null;
    }
}
