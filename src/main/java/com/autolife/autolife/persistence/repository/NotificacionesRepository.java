package com.autolife.autolife.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.autolife.autolife.persistence.entity.Notificaciones;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Long> {
    @Query(value = "SELECT n FROM Notificaciones n WHERE n.usuario = :dni")
    List<Notificaciones> findByUser(@Param("dni") String dni);

    @Query(value = "SELECT n FROM Notificaciones n WHERE n.taller = :dni")
    List<Notificaciones> findByTaller(@Param("dni") String dni);
}
