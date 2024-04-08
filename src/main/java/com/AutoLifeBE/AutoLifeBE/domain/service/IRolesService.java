package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Roles;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface IRolesService {
    List<Roles> getRoles();
    Roles newRoles(Roles roles);
    Optional<Roles> findRoles(Integer id);
    boolean deleteRoles(Integer id);
}
