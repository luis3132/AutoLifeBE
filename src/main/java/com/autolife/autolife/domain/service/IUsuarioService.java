package com.autolife.autolife.domain.service;

import java.util.Optional;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.persistence.entity.Usuarios;

public interface IUsuarioService {
    Optional<Usuarios> findByUsuario(String dni);
    Usuarios save(UsuarioNuevo usuario);
    Usuarios update(UsuarioNuevo usuario);
    Boolean delete(String dni);
}