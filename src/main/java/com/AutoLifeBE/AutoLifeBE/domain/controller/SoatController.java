package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.SoatService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Soat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/soat")
public class SoatController {
    
    @Autowired
    private SoatService soatService;
    
    @PostMapping("/new")
    public ResponseEntity<Soat> addSoat(@RequestBody Soat soat){
        Soat obj = soatService.newSoatSID(soat);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Soat> findById(@PathVariable("id") String id){
        return soatService.findSoat(id)
                .map((Soat) -> new ResponseEntity<>(Soat, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Soat> deleteById(@PathVariable("id") String id){
        Optional<Soat> obj = soatService.findSoat(id);
        if (obj.isPresent()){
            soatService.deleteSoat(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
