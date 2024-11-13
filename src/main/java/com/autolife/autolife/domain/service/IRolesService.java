package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.persistence.entity.Roles;

public interface IRolesService {
    Optional<Roles> findById(Integer id);
}
