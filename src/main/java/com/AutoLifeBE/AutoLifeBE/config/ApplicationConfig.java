package com.AutoLifeBE.AutoLifeBE.config;

import com.AutoLifeBE.AutoLifeBE.persistence.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Luis Andres Gonzalez Corzo
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
        return nombreUsuario -> usuariosRepository.findNombreUsuario(nombreUsuario)
                .orElseThrow(()-> new UsernameNotFoundException("User name not found"));
    }
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
