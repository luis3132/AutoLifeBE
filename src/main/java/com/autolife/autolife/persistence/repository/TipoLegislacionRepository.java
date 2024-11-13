package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.TipoLegislacion;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface TipoLegislacionRepository extends JpaRepository<TipoLegislacion, Integer> {
    
}
