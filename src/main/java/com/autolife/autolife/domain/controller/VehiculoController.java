package com.autolife.autolife.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.vehiculo.VehiculoCambioDuenoDTO;
import com.autolife.autolife.domain.dto.vehiculo.VehiculoNuevo;
import com.autolife.autolife.domain.service.TipoVehiculoService;
import com.autolife.autolife.domain.service.VehiculosService;
import com.autolife.autolife.persistence.entity.TipoVehiculo;
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

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping("/list/{dni}")
    @Secured({"USER"})
    public ResponseEntity<List<Vehiculo>> findByUser(@PathVariable("dni") String dni) {
        return ResponseEntity.ok(vehiculosService.findByUser(dni));
    }

    @GetMapping("/tipovehiculo/list")
    public ResponseEntity<List<TipoVehiculo>> findTipoVehiculo() {
        return ResponseEntity.ok(tipoVehiculoService.findAll());
    }

    @PostMapping("/new")
    @Secured({"USER"})
    public ResponseEntity<Vehiculo> save(@RequestBody VehiculoNuevo vehiculo) {
        return ResponseEntity.ok(vehiculosService.save(vehiculo));
    }

    @PutMapping("/update")
    public ResponseEntity<Vehiculo> update(@RequestBody VehiculoNuevo vehiculo) {
        return ResponseEntity.ok(vehiculosService.update(vehiculo));
    }

    @PostMapping("/update/cambiodueno")
    @Secured({"USER"})
    public ResponseEntity<Vehiculo> updateDueno(@RequestBody VehiculoCambioDuenoDTO vehiculo) {
        Vehiculo veh = vehiculosService.updateDueno(vehiculo);
        if (veh != null) {
            return ResponseEntity.ok(veh);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{numSerie}")
    public ResponseEntity<Boolean> delete(@PathVariable("numSerie") String numSerie) {
        return ResponseEntity.ok(vehiculosService.delete(numSerie));
    }
    
}
