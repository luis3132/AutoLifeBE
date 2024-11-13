package com.autolife.autolife.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autolife.autolife.persistence.entity.Vehiculo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    
    @Query("SELECT v FROM Vehiculo v WHERE v.usuario = ?1")
    public List<Vehiculo> findByUser(String dni);
}
