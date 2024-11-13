package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.domain.dto.FotosNuevo;
import com.autolife.autolife.persistence.entity.Fotos;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IFotosService {
    public Optional<Fotos> findById(Long id);
    public Fotos save(FotosNuevo fotos);
    public Boolean delete(Long id);
}
