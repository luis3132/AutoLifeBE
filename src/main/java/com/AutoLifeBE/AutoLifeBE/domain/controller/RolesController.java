package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.RolesService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Roles;
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
@RequestMapping("/api/roles")
public class RolesController {
    @Autowired
    private RolesService rolesservice;
    
    //List Roles
    @GetMapping("/list")
    public List<Roles> getRoles(){
        return rolesservice.getRoles();
    }
    
    //List by ID
    @GetMapping("/list/{id}")
    public ResponseEntity<Roles> findbyID(@PathVariable("id") Integer id){
        return rolesservice.findRoles(id)
                .map(((Roles) -> new ResponseEntity<>(Roles, HttpStatus.OK)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // add Roles
    @PostMapping("/new")
    public ResponseEntity<Roles> addRoles(@RequestBody Roles roles){
        if (!rolesservice.findRoles(roles.getId()).isPresent()){
            Roles obj = rolesservice.newRoles(roles);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    // Edit Roles
    @PutMapping("/edit")
    public ResponseEntity<Roles> editRoles(@RequestBody Roles roles){
        Optional<Roles> obj = rolesservice.findRoles(roles.getId());
        if(obj.isPresent()){
            obj.get().setId(roles.getId());
            obj.get().setRol(roles.getRol());
            rolesservice.newRoles(obj.get());
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // delete Roles
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Roles> deleteRoles(@PathVariable("id") Integer id){
        Optional<Roles> obj = rolesservice.findRoles(id);
        if (obj.isPresent()){
            rolesservice.deleteRoles(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
