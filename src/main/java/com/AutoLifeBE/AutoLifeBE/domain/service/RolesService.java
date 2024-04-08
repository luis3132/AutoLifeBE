package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Roles;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.RolesRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Service
@Transactional
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesrepository;
    
    /**
     * 
     * @return all Roles in data base
     */
    @Override
    public List<Roles> getRoles() {
        return rolesrepository.findAll();
    }

    /**
     * 
     * @param roles object of Roles to add
     * @return nothing
     */
    @Override
    public Roles newRoles(Roles roles) {
        return rolesrepository.save(roles);
    }

    /**
     * 
     * @param id Id of Roles to find
     * @return object of Roles with this id
     */
    @Override
    public Optional<Roles> findRoles(Integer id) {
        return rolesrepository.findById(id);
    }

    /**
     * 
     * @param id Id of Roles to delete
     * @return nothing
     */
    @Override
    public boolean deleteRoles(Integer id) {
        if(findRoles(id).isPresent()){
            rolesrepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
