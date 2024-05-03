package com.AutoLifeBE.AutoLifeBE.Auth;

import com.AutoLifeBE.AutoLifeBE.domain.dto.LoginDTO;
import com.AutoLifeBE.AutoLifeBE.domain.dto.RegisterDTO;
import com.AutoLifeBE.AutoLifeBE.domain.service.VehiculoService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Vehiculo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private VehiculoService vehiculoservice;
    @Autowired
    private final AuthService authService;
    
    @GetMapping("/vehiculo/list/publico/{bl}")
    public List<Vehiculo> findByUsuario(@PathVariable("bl") Boolean publico){
        return vehiculoservice.getPublicVehiculo(publico);
    }
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO login){
        return ResponseEntity.ok(authService.login(login));
    }
    
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(authService.register(registerDTO));
    }
}
