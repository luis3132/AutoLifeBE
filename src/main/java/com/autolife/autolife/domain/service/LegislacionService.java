package com.autolife.autolife.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.legislacion.LegislacionEditar;
import com.autolife.autolife.domain.dto.legislacion.LegislacionNueva;
import com.autolife.autolife.persistence.entity.Legislacion;
import com.autolife.autolife.persistence.entity.TipoLegislacion;
import com.autolife.autolife.persistence.entity.Vehiculo;
import com.autolife.autolife.persistence.repository.LegislacionRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class LegislacionService implements ILegislacionService {
    
    @Autowired
    private LegislacionRepository legislacionRepository;

    @Autowired
    private VehiculosService vehiculoService;

    @Autowired
    private TipoLegislacionService tipoLegislacionService;

    @Override
    public List<Legislacion> saveAll(List<LegislacionNueva> legislacion) {
        List<Legislacion> legislacionList = new ArrayList<>();
        for (LegislacionNueva list: legislacion){
            Legislacion entity = convertDTOtoEntity(list);
            legislacionList.add(entity);
        }
        return legislacionRepository.saveAll(legislacionList);
    }

    @Override
    public Legislacion update(LegislacionEditar legislacion) {
        Optional<Legislacion> legislacionEntity = legislacionRepository.findById(legislacion.getId());
        if (legislacionEntity.isPresent()) {
            return legislacionRepository.save(convertDTOtoEntity(legislacion));
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Legislacion> legislacion = legislacionRepository.findById(id);
        if (legislacion.isPresent()) {
            legislacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Legislacion convertDTOtoEntity(LegislacionNueva legislacion) {
        LegislacionEditar legislacionEditar = new LegislacionEditar();
        legislacionEditar.setDescripcion(legislacion.getDescripcion());
        legislacionEditar.setFechaFin(legislacion.getFechaFin());
        legislacionEditar.setFechaInicio(legislacion.getFechaInicio());
        legislacionEditar.setTipoLegislacion(legislacion.getTipoLegislacion());
        legislacionEditar.setVehiculo(legislacion.getVehiculo());
        legislacionEditar.setKilometraje(legislacion.getKilometraje());
        return convertDTOtoEntity(legislacionEditar);
    }

    private Legislacion convertDTOtoEntity(LegislacionEditar legislacion) {
        Legislacion entity = new Legislacion();

        Optional<Vehiculo> vehiculo = vehiculoService.findByNumSerie(legislacion.getVehiculo());

        Optional<TipoLegislacion> tipoLegislacion = tipoLegislacionService.findById(legislacion.getTipoLegislacion());

        if (vehiculo.isPresent() && tipoLegislacion.isPresent()) {
            entity.setId(legislacion.getId());
            entity.setDescripcion(legislacion.getDescripcion());
            entity.setFechaFin(legislacion.getFechaFin());
            entity.setFechaInicio(legislacion.getFechaInicio());
            entity.setKilometraje(legislacion.getKilometraje());
            entity.setTipoLegislacion(tipoLegislacion.get());
            entity.setVehiculo(vehiculo.get());

            return entity;
        }
        return null;
    }
}
