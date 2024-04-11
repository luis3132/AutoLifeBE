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
    /**
     * verify the login
     * @param email of the Usuario
     * @param contrasena of the Usuario
     * @return true if this user exist
     */
    @Override
    public boolean loginEmail(String email, String contrasena) {
        Optional<Usuarios> obj = findEmail(email);
        return obj.get().getContrasena().equals(contrasena);
    }
    /**
     * verify the login
     * @param nombreUsuario of the Usuario
     * @param contrasena of the Usuario
     * @return true if this user exist
     */
    @Override
    public boolean loginNombreUsuario(String nombreUsuario, String contrasena) {
        Optional<Usuarios> obj = findNombreUsuario(nombreUsuario);
        return obj.get().getContrasena().equals(contrasena);
    }
    /**
     * verify if the nombreUsuario is unique
     * @param nombreUsuario of the Usuario
     * @return true if this is already exist
     */
    @Override
    public Optional<Usuarios> findNombreUsuario(String nombreUsuario) {
        return usuariosrepository.findNombreUsuario(nombreUsuario);
    }
    /**
     * verify if the email is unique
     * @param Email of the Usuario
     * @return true if this is already exist
     */
    @Override
    public Optional<Usuarios> findEmail(String Email) {
        return usuariosrepository.findEmail(Email);
    }
}
