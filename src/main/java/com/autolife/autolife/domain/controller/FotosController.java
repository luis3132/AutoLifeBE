package com.autolife.autolife.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.FotosNuevo;
import com.autolife.autolife.domain.service.FotosService;
import com.autolife.autolife.persistence.entity.Fotos;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/fotos")
public class FotosController {

    @Autowired
    private FotosService fotosService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Fotos> findById(@PathVariable Long id) {
        return ResponseEntity.ok(fotosService.findById(id).get());
    }

    @PostMapping("/new")
    public ResponseEntity<Fotos> save(@RequestBody FotosNuevo fotos) {
        return ResponseEntity.ok(fotosService.save(fotos));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (fotosService.delete(id)) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
