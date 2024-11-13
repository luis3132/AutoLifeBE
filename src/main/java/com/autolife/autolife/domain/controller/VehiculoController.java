package com.autolife.autolife.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.autolife.autolife.domain.dto.VehiculoNuevo;
import com.autolife.autolife.domain.service.VehiculosService;
import com.autolife.autolife.persistence.entity.Vehiculo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculosService vehiculosService;

    @GetMapping("/list/{dni}")
    public ResponseEntity<List<Vehiculo>> findByUser(@PathVariable("dni") String dni) {
        return ResponseEntity.ok(vehiculosService.findByUser(dni));
    }

    @PostMapping("/new")
    public ResponseEntity<Vehiculo> save(@RequestBody VehiculoNuevo vehiculo) {
        return ResponseEntity.ok(vehiculosService.save(vehiculo));
    }

    @PutMapping("/update")
    public ResponseEntity<Vehiculo> update(@RequestBody VehiculoNuevo vehiculo) {
        return ResponseEntity.ok(vehiculosService.update(vehiculo));
    }

    @DeleteMapping("/delete/{numSerie}")
    public ResponseEntity<Boolean> delete(@PathVariable("numSerie") String numSerie) {
        return ResponseEntity.ok(vehiculosService.delete(numSerie));
    }
    
}
