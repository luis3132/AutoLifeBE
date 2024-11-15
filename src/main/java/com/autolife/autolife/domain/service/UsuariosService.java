package com.autolife.autolife.domain.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.persistence.entity.Roles;
import com.autolife.autolife.persistence.entity.Usuarios;
import com.autolife.autolife.persistence.repository.UsuariosRepository;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Service
public class UsuariosService implements IUsuarioService {
    
    @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private RolesService rolesService;

    @Override
    public Optional<Usuarios> findByUsuario(String dni) {
        return usuarioRepository.findById(dni);
    }

    @Override
    public UserDetails findByNombreUsuario(String nombreUsuario) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRoles().getRol());

        Set<GrantedAuthority> authorities = Set.of(authority);

        return new User(usuario.getNombreUsuario(), usuario.getContrasena(), authorities);
    }

    @Override
    public Optional<Usuarios> findByNombreUsuarioUserData(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Usuarios save(UsuarioNuevo usuario) {
        return usuarioRepository.save(convertDTOtoEntity(usuario));
    }

    @Override
    public Usuarios update(UsuarioNuevo usuario) {
        return usuarioRepository.save(convertDTOtoEntity(usuario));
    }

    @Override
    public Boolean delete(String dni) {
        if (usuarioRepository.findById(dni).isPresent()) {
            usuarioRepository.deleteById(dni);
            return true;
        }
        return false;
    }

    private Usuarios convertDTOtoEntity(UsuarioNuevo usuario) {
        Usuarios user = new Usuarios();
        Optional<Roles> roles = rolesService.findById(usuario.getRoles());

        user.setDni(usuario.getDni());
        user.setNombre(usuario.getNombre());
        user.setApellidos(usuario.getApellidos());
        user.setTelefono(usuario.getTelefono());
        user.setDireccion(usuario.getDireccion());
        user.setContrasena(usuario.getContrasena());
        user.setEmail(usuario.getEmail());
        user.setNombreUsuario(usuario.getNombreUsuario());

        if (roles.isPresent()) {
            user.setRoles(roles.get());
            return user;
        }
        return null;
    }
}
