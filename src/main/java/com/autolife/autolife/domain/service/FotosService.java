package com.autolife.autolife.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.FotosNuevo;
import com.autolife.autolife.persistence.entity.Fotos;
import com.autolife.autolife.persistence.repository.FotosRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class FotosService implements IFotosService {
     
    @Autowired
    private FotosRepository fotosRepository;

    @Override
    public Optional<Fotos> findById(Long id) {
        return fotosRepository.findById(id);
    }

    @Override
    public Fotos save(FotosNuevo fotos) {
        return fotosRepository.save(convertDTOtoEntity(fotos));
    }

    @Override
    public Boolean delete(Long id) {
        if (fotosRepository.findById(id).isPresent()) {
            fotosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Fotos convertDTOtoEntity(FotosNuevo fotos) {
        Fotos entity = new Fotos();

        entity.setPath(fotos.getPath());
        entity.setVehiculo(fotos.getVehiculo());
        entity.setServicio(fotos.getServicio());
        entity.setAccidentes(fotos.getAccidentes());
        entity.setUsuarios(fotos.getUsuarios());
        entity.setLegislacion(fotos.getLegislacion());
        entity.setPiezas(fotos.getPiezas());
        entity.setPartes(fotos.getPartes());

        return entity;
    }
}
