package com.autolife.autolife.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.UsuarioNuevo;
import com.autolife.autolife.domain.service.UsuariosService;
import com.autolife.autolife.persistence.entity.Usuarios;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuarioService;

    @GetMapping("/list/{dni}")
    public ResponseEntity<Usuarios> findUsuario(@PathParam("dni") String dni) {
        return ResponseEntity.ok(usuarioService.findByUsuario(dni).get());
    }

    @PutMapping("/update")
    public ResponseEntity<Usuarios> updateUsuario(@RequestBody UsuarioNuevo usuarioNuevo) {
        return ResponseEntity.ok(usuarioService.update(usuarioNuevo));
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Boolean> deleteUsuario(@PathParam("dni") String dni) {
        return ResponseEntity.ok(usuarioService.delete(dni));
    }
}
