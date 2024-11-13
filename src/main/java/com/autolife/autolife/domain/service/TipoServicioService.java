package com.autolife.autolife.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.persistence.entity.TipoServicio;
import com.autolife.autolife.persistence.repository.TipoServicioRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class TipoServicioService implements ITipoServicioService {
    
    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Override
    public Optional<TipoServicio> findById(Integer id) {
        return tipoServicioRepository.findById(id);
    }
    
}
