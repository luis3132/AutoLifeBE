package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.FotosService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Fotos;
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
@RequestMapping("/api/fotos")
public class FotosController {

    @Autowired
    private FotosService fotosService;

    @PostMapping("/new")
    public ResponseEntity<Fotos> addFoto(@RequestBody Fotos foto) {
        if (fotosService.findFoto(foto.getId()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Fotos obj = fotosService.newFoto(foto);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Fotos> findbyID(@PathVariable("id") String id) {
        return fotosService.findFoto(id)
                .map((Fotos) -> new ResponseEntity<>(Fotos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fotos> deleteFoto(@PathVariable("id") String id) {
        Optional<Fotos> obj = fotosService.findFoto(id);
        if (obj.isPresent()){
            fotosService.deleteFoto(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
