package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.persistence.entity.TipoServicio;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ITipoServicioService {
    Optional<TipoServicio> findById(Integer id);
}
