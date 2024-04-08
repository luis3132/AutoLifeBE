package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.UsuariosRepository;
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
public class UsuariosService implements IUsuariosService {
    @Autowired
    private UsuariosRepository usuariosrepository;

    /**
     * 
     * @return all Usuarios in the data base 
     */
    @Override
    public List<Usuarios> getUsuario() {
        return (List<Usuarios>) usuariosrepository.findAll();
    }

    /**
     *  add new usuario
     * @param usuarios object of Usuarios to add in data base
     * @return nothing
     */
    @Override
    public Usuarios newUsuario(Usuarios usuarios) {
        return usuariosrepository.save(usuarios);
    }

    /**
     *  delete usuario
     * @param dni the id of the Usuarios that is going to delete
     * @return true if the task was done or false instead
     */
    @Override
    public boolean deleteUsuario(String dni) {
        if(findUsuario(dni).isPresent()){
            usuariosrepository.deleteById(dni);
            return true;
        } else {
            return false;
        }
    }

    /**
     * find usuario by dni
     * @param dni id of Usuario that is going to find
     * @return optional with one usuario
     */
    @Override
    public Optional<Usuarios> findUsuario(String dni) {
        return usuariosrepository.findById(dni);
    }
    
}
