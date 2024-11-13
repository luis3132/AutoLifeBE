package com.autolife.autolife.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolife.autolife.persistence.entity.Roles;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    
}
