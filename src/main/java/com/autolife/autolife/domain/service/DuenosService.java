package com.autolife.autolife.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.DuenoNuevo;
import com.autolife.autolife.persistence.entity.Duenos;
import com.autolife.autolife.persistence.entity.DuenosPK;
import com.autolife.autolife.persistence.entity.Usuarios;
import com.autolife.autolife.persistence.entity.Vehiculo;
import com.autolife.autolife.persistence.repository.DuenosRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class DuenosService implements IDuenosService {

    @Autowired
    private DuenosRepository duenosRepository;

    @Autowired
    private VehiculosService vehiculosService;

    @Autowired
    private UsuariosService usuariosService;

    @Override
    public Optional<Duenos> findById(DuenosPK id) {
        return duenosRepository.findById(id);
    }

    @Override
    public Duenos save(DuenoNuevo duenos) {
        return duenosRepository.save(convertDTOtoEntity(duenos));
    }

    @Override
    public Duenos update(DuenoNuevo duenos) {
        Optional<Duenos> entity = findById(new DuenosPK(duenos.getVehiculo(), duenos.getUsuario()));
        if (entity.isPresent()) {
            return duenosRepository.save(convertDTOtoEntity(duenos));
        }
        return null;
    }

    @Override
    public Boolean delete(DuenosPK id) {
        if (findById(id).isPresent()) {
            duenosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Duenos convertDTOtoEntity(DuenoNuevo duenos) {

        Duenos entity = new Duenos();

        Optional<Usuarios> usuario = usuariosService.findByUsuario(duenos.getUsuario());

        Optional<Vehiculo> vehiculo = vehiculosService.findByNumSerie(duenos.getVehiculo());

        if (usuario.isPresent() && vehiculo.isPresent()) {
            entity.setDuenosPK(new DuenosPK(duenos.getVehiculo(), duenos.getUsuario()));
            entity.setKmStart(duenos.getKmStart());
            entity.setKmFinish(duenos.getKmFinish());
            entity.setDateStart(duenos.getDateStart());
            entity.setDateFinish(duenos.getDateFinish());
            entity.setCiudadPromTransi(duenos.getCiudadPromTransi());
            entity.setUsuario(usuario.get());
            entity.setVehiculo(vehiculo.get());

            return entity;
        }
        return null;
    }
}
