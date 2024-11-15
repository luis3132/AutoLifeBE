package com.autolife.autolife.secure.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.autolife.autolife.persistence.repository.UsuariosRepository;
import org.springframework.security.authentication.AuthenticationProvider;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    
    @Autowired
    private final UsuariosRepository usuariosRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(PasswordEncoder());

        return authenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailService() {
        return nombreUsuario -> usuariosRepository.findByNombreUsuario(nombreUsuario)
                .map(user -> new User(user.getNombreUsuario(), user.getContrasena(), new ArrayList<>()))
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    }

    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
