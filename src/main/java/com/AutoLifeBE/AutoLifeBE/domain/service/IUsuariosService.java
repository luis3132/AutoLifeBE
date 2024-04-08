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
}
