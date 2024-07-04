package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.SeguroService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Seguro;
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
@RequestMapping("/api/seguro")
public class SeguroController {
    
    @Autowired
    private SeguroService seguroService;
    
    @PostMapping("/new")
    public ResponseEntity<Seguro> addSeguro(@RequestBody Seguro seguro){
        Seguro obj = seguroService.newSeguro(seguro);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Seguro> findById(@PathVariable("id") Long id){
        return seguroService.findSeguro(id)
                .map((Seguro) -> new ResponseEntity<>(Seguro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Seguro> deleteById(@PathVariable("id") Long id){
        Optional<Seguro> obj = seguroService.findSeguro(id);
        if (obj.isPresent()){
            seguroService.deleteSeguro(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
