package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.TipoVehiculo;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
    
}
