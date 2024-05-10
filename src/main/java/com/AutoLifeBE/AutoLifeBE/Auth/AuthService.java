package com.AutoLifeBE.AutoLifeBE.Auth;

import com.AutoLifeBE.AutoLifeBE.domain.dto.LoginDTO;
import com.AutoLifeBE.AutoLifeBE.domain.dto.RegisterDTO;
import com.AutoLifeBE.AutoLifeBE.jwt.JwtService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UsuariosRepository usuariosRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginDTO request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserLogin(),request.getContrasena()));
        UserDetails user = usuariosRepository.findNombreUsuario(request.getUserLogin()).orElseThrow();
        String token = jwtService.getToken(user);
        
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    
    public AuthResponse register(RegisterDTO request){
        Usuarios user = Usuarios.builder()
                .dni(request.getDni())
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .direccion(request.getDireccion())
                .email(request.getEmail())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .nombreUsuario(request.getNombreUsuario())
                .telefono(request.getTelefono())
                .roles(request.getRoles())
                .build();
        usuariosRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
