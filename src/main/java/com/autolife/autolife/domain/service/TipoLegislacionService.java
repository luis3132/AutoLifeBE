package com.autolife.autolife.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.persistence.entity.TipoLegislacion;
import com.autolife.autolife.persistence.repository.TipoLegislacionRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

 @Service
public class TipoLegislacionService implements ITipoLegislacionService {
    
    @Autowired
    private TipoLegislacionRepository tipoLegislacionRepository;

    @Override
    public Optional<TipoLegislacion> findById(Integer id) {
        return tipoLegislacionRepository.findById(id);
    }
}
