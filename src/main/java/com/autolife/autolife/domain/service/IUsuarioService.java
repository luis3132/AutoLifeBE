package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.persistence.entity.Usuarios;

public interface IUsuarioService {
    Optional<Usuarios> findByUsuario(String dni);
    UserDetails findByNombreUsuario(String nombreUsuario);
    Optional<Usuarios> findByNombreUsuarioUserData(String nombreUsuario);
    List<Usuarios> findTalleres();
    Usuarios save(UsuarioNuevo usuario);
    Usuarios update(UsuarioNuevo usuario);
    Boolean delete(String dni);
}