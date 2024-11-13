package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.domain.dto.DuenoNuevo;
import com.autolife.autolife.persistence.entity.Duenos;
import com.autolife.autolife.persistence.entity.DuenosPK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IDuenosService {
    public Optional<Duenos> findById(DuenosPK id);
    public Duenos save(DuenoNuevo duenos);
    public Duenos update(DuenoNuevo duenos);
    public Boolean delete(DuenosPK id);
}
