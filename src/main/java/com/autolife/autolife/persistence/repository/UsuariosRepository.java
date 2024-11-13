package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Usuarios;

/**
 * 
 * @author Luis Andres Gonzalez Corzo 
 */

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    
}
