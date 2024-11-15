package com.autolife.autolife.secure.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.domain.dto.auth.LoginDTO;
import com.autolife.autolife.domain.service.UsuariosService;
import com.autolife.autolife.persistence.entity.Usuarios;
import com.autolife.autolife.secure.jwt.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@RequiredArgsConstructor
public class AuthService {
    
    @Autowired
    private final UsuariosService usuariosService;

    @Autowired
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombreUsuario(), request.getContrasena()));
        UserDetails user = usuariosService.findByNombreUsuario(request.getNombreUsuario());

        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(UsuarioNuevo request) {
        request.setContrasena(passwordEncoder.encode(request.getContrasena()));
        Usuarios usuario = usuariosService.save(request);

        UserDetails user = usuariosService.findByNombreUsuario(usuario.getNombreUsuario());

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

