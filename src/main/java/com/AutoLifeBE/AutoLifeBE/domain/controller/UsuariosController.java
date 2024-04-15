package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.dto.LoginDTO;
import com.AutoLifeBE.AutoLifeBE.domain.service.UsuariosService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Usuarios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @GetMapping("/list/nombreusuario/{id}")
    public ResponseEntity<Usuarios> findbyNombreUsuario(@PathVariable("id") String nombreusuario){
        return usuariosservice.findNombreUsuario(nombreusuario)
                .map((Usuarios) -> new ResponseEntity<>(Usuarios, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // add Usuario
    @PostMapping("/new")
    public ResponseEntity<Usuarios> addUsuarios(@RequestBody Usuarios usuarios){
        boolean email = usuariosservice.findEmail(usuarios.getEmail()).isPresent();
        boolean nombreUsuario = usuariosservice.findNombreUsuario(usuarios.getNombreUsuario()).isPresent();
        if (!usuariosservice.findUsuario(usuarios.getDni()).isPresent() && email && nombreUsuario){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Usuarios obj = usuariosservice.newUsuario(usuarios);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
    }
    // Edit Usuarios
    @PutMapping("/edit")
    public ResponseEntity<Usuarios> editUsuarios(@RequestBody Usuarios usuarios){
        Optional<Usuarios> obj = usuariosservice.findUsuario(usuarios.getDni());
        boolean email = usuariosservice.findEmail(usuarios.getEmail()).isPresent();
        boolean nombreUsuario = usuariosservice.findNombreUsuario(usuarios.getNombreUsuario()).isPresent();
        if (!email && !nombreUsuario) {
            if(obj.isPresent()){
                obj.get().setApellidos(usuarios.getApellidos());
                obj.get().setContrasena(usuarios.getContrasena());
                obj.get().setDireccion(usuarios.getDireccion());
                obj.get().setDni(usuarios.getDni());
                obj.get().setEmail(usuarios.getEmail());
                obj.get().setNombre(usuarios.getNombre());
                obj.get().setTelefono(usuarios.getTelefono());
                obj.get().setRoles(usuarios.getRoles());
                obj.get().setContrasena(usuarios.getContrasena());
                obj.get().setNombreUsuario(usuarios.getNombreUsuario());
                usuariosservice.newUsuario(obj.get());
                return new ResponseEntity<>(obj.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(obj.get(), HttpStatus.CONFLICT);
        }
    }
    // delete Usuarios
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuarios> deleteUsuarios(@PathVariable("id") String dni){
        Optional<Usuarios> obj = usuariosservice.findUsuario(dni);
        if (obj.isPresent()){
            usuariosservice.deleteUsuario(dni);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Login Email
    @PostMapping("/login/email")
    public ResponseEntity<?> loginEmail(@RequestBody LoginDTO logindto){
        Map<String, Object> response = new HashMap<>();
        try {
            if (usuariosservice.loginEmail(logindto.getUserLogin(), logindto.getContrasena())){
                Usuarios usuario = usuariosservice.findEmail(logindto.getUserLogin()).get();
                response.put("Usuario", usuario);
                response.put("Mensaje", "Datos correctos");
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("Usuario", null);
                response.put("Mensaje", "Alerta: Usuario o contrasena incorrectos");
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch(Exception e) {
                response.put("Usuario", null);
                response.put("Mensaje", "Ha ocurrido un error");
                response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    // Login nombreUsuario
    @PostMapping("/login/nombreusuario")
    public ResponseEntity<?> loginUserName(@RequestBody LoginDTO logindto){
        Map<String, Object> response = new HashMap<>();
        try {
            if (usuariosservice.loginNombreUsuario(logindto.getUserLogin(), logindto.getContrasena())){
                Usuarios usuario = usuariosservice.findNombreUsuario(logindto.getUserLogin()).get();
                response.put("Usuario", usuario);
                response.put("Mensaje", "Datos correctos");
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("Usuario", null);
                response.put("Mensaje", "Alerta: Usuario o contrasena incorrectos");
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch(Exception e) {
                response.put("Usuario", null);
                response.put("Mensaje", "Ha ocurrido un error");
                response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
