package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.persistence.entity.TipoVehiculo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ITipoVehiculoService {
    Optional<TipoVehiculo> findById(Integer id);
}
