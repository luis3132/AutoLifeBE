package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import com.autolife.autolife.persistence.entity.TipoServicio;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ITipoServicioService {
    List<TipoServicio> findAll();
    Optional<TipoServicio> findById(Integer id);
}
