package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Fotos;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface FotosRepository extends JpaRepository<Fotos, Long> {
    
}
