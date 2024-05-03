package com.AutoLifeBE.AutoLifeBE.config;

import com.AutoLifeBE.AutoLifeBE.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtAuthenticationFilter authenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            return http
                    .csrf(csrf
                            -> csrf.disable())
                    .authorizeHttpRequests(authRequest
                            -> authRequest
                            .requestMatchers("/auth/**").permitAll()
                            .anyRequest().authenticated())
                    .sessionManagement(sessionManager->
                            sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        } catch (Exception e) {
            // Manejar la excepción aquí
            e.printStackTrace(); // O cualquier otra acción que desees realizar
            // Retornar algo apropiado en caso de error, o lanzar otra excepción
            return null;
        }
    }

}
