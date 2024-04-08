package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.UsuariosService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosservice;
    // List all Usuarios
    @GetMapping("/list")
    public List<Usuarios> getUsuarios(){
        return usuariosservice.getUsuario();
    }
    // List by ID
    @GetMapping("/list/{id}")
    public ResponseEntity<Usuarios> findbyID(@PathVariable("id") String dni){
        return usuariosservice.findUsuario(dni)
                .map((Usuarios) -> new ResponseEntity<>(Usuarios, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // add Usuario
    @PostMapping("/new")
    public ResponseEntity<Usuarios> addUsuarios(@RequestBody Usuarios usuarios){
        if (usuariosservice.findUsuario(usuarios.getDni()).isPresent()){
            Usuarios obj = usuariosservice.newUsuario(usuarios);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    // Edit Usuarsios
    @PutMapping("/")
    public ResponseEntity<Usuarios> editUsuarios(@RequestBody Usuarios usuarios){
        Optional<Usuarios> obj = usuariosservice.findUsuario(usuarios.getDni());
        if(obj.isPresent()){
            obj.get().setApellidos(usuarios.getApellidos());
            obj.get().setContrasena(usuarios.getContrasena());
            obj.get().setDireccion(usuarios.getDireccion());
            obj.get().setDni(usuarios.getDni());
            obj.get().setEmail(usuarios.getEmail());
            obj.get().setNombre(usuarios.getNombre());
            obj.get().setTelefono(usuarios.getTelefono());
            usuariosservice.newUsuario(obj.get());
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // delete Usuarios
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuarios> deleteUsuarios(@PathVariable("id") String dni){
        Optional<Usuarios> obj = usuariosservice.findUsuario(dni);
        if (obj.isPresent()){
            usuariosservice.deleteUsuario(dni);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
