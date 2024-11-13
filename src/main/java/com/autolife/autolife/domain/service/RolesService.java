package com.autolife.autolife.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.persistence.entity.Roles;
import com.autolife.autolife.persistence.repository.RolesRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Optional<Roles> findById(Integer id) {
        return rolesRepository.findById(id);
    }
    
}
