package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.persistence.entity.TipoVehiculo;
import com.autolife.autolife.persistence.repository.TipoVehiculoRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class TipoVehiculoService implements ITipoVehiculoService {
    
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Override
    public Optional<TipoVehiculo> findById(Integer id) {
        return tipoVehiculoRepository.findById(id);
    }

    @Override
    public List<TipoVehiculo> findAll() {
        return tipoVehiculoRepository.findAll();
    }
}
