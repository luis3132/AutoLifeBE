package com.autolife.autolife.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autolife.autolife.persistence.entity.Usuarios;

/**
 * 
 * @author Luis Andres Gonzalez Corzo 
 */

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    
    @Query("SELECT u FROM Usuarios u WHERE u.nombreUsuario = ?1")
    Optional<Usuarios> findByNombreUsuario(String nombreUsuario);

    @Query("SELECT u FROM Usuarios u WHERE u.roles.id = 3")
    List<Usuarios> findTalleres();
}
