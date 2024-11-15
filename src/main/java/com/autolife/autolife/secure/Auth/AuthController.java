package com.autolife.autolife.secure.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.domain.dto.auth.LoginDTO;
import com.autolife.autolife.secure.jwt.JwtService;

import io.jsonwebtoken.Claims;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO login){
        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UsuarioNuevo registerDTO){
        return ResponseEntity.ok(authService.register(registerDTO));
    }

    @PostMapping("/verify")
    public LoginDTO verify(@RequestBody AuthResponse authResponse){
        LoginDTO loginDTO = new LoginDTO(jwtService.getClaim(authResponse.getToken(), Claims::getSubject), "Encrypted");
        return loginDTO;
    }
}
