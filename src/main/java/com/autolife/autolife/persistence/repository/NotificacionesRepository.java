package com.autolife.autolife.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autolife.autolife.persistence.entity.Notificaciones;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Long> {
    @Query(value = "SELECT n FROM notificaciones n WHERE n.usuario = :dni", nativeQuery = true)
    List<Notificaciones> findByUser(String dni);

    @Query(value = "SELECT n FROM notificaciones n WHERE n.taller = :dni", nativeQuery = true)
    List<Notificaciones> findByTaller(String dni);
}
