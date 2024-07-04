package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.TecnicoMecanicaService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.TecnicoMecanica;
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
@RequestMapping("/api/tecnicomecanica")
public class TecnicoMecanicaController {
    
    @Autowired
    private TecnicoMecanicaService tecnicoMecanicaService;
    
    @PostMapping("/new")
    public ResponseEntity<TecnicoMecanica> addTecnicoMecanica(@RequestBody TecnicoMecanica tecnicoMecanica){
        TecnicoMecanica obj = tecnicoMecanicaService.newTecnicoMecanica(tecnicoMecanica);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<TecnicoMecanica> findByID(@PathVariable("id") Long id){
        return tecnicoMecanicaService.findTecnicoMecanica(id)
                .map((TecnicoMecanica) -> new ResponseEntity<>(TecnicoMecanica, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TecnicoMecanica> deleteTecnicoMecanica(@PathVariable("id") Long id){
        Optional<TecnicoMecanica> obj = tecnicoMecanicaService.findTecnicoMecanica(id);
        if (obj.isPresent()){
            tecnicoMecanicaService.deleteTecnicoMecanica(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
