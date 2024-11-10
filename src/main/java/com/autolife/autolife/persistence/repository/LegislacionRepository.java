package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Legislacion;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface LegislacionRepository extends JpaRepository<Legislacion, Long> {
    
}
