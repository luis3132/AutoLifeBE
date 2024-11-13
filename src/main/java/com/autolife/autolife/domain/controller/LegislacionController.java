package com.autolife.autolife.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.legislacion.LegislacionEditar;
import com.autolife.autolife.domain.dto.legislacion.LegislacionNueva;
import com.autolife.autolife.domain.service.LegislacionService;
import com.autolife.autolife.persistence.entity.Legislacion;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/legislacion")
public class LegislacionController {
   
    @Autowired
    private LegislacionService legislacionService;

    @PostMapping("/new")
    public ResponseEntity<List<Legislacion>> saveAll(@RequestBody List<LegislacionNueva> legislacion) {
        return ResponseEntity.ok(legislacionService.saveAll(legislacion));
    }

    @PutMapping("/update")
    public ResponseEntity<Legislacion> update(@RequestBody LegislacionEditar legislacion) {
        return ResponseEntity.ok(legislacionService.update(legislacion));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(legislacionService.delete(id));
    }
}
