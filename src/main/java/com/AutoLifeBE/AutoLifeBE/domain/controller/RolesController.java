package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.RolesService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    //add roles
    @PostMapping("/new")
    public ResponseEntity<Roles> addRoles(@RequestBody Roles roles){
        Roles obj = rolesservice.newRoles(roles);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    // edit Roles
    //@PutMapping("/")
}
