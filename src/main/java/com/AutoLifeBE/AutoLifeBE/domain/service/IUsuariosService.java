package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface IUsuariosService {
    List<Usuarios> getUsuario();
    Usuarios newUsuario(Usuarios usuarios);
    Optional<Usuarios> findUsuario(String dni);
    boolean deleteUsuario(String dni);
    boolean loginEmail(String email, String contrasena);
    boolean loginNombreUsuario(String nombreUsuario, String contrasena);
    Optional<Usuarios> findNombreUsuario(String nombreUsuario);
    Optional<Usuarios> findEmail(String email);
}
