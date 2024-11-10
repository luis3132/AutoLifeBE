package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Vehiculo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    
}
