package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.persistence.entity.TipoLegislacion;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ITipoLegislacionService {
    Optional<TipoLegislacion> findById(Integer id);
}
