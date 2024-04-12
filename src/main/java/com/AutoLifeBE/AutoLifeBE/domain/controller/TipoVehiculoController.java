package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.TipoVehiculoService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.TipoVehiculo;
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
@RequestMapping("/api/tipovehiculo")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoService tipovehiculoservice;
    
    @GetMapping("/list")
    public List<TipoVehiculo> getTipoVehiculo(){
        return tipovehiculoservice.getTipoVehiculo();
    }
    
    @GetMapping("/list/{id}")
    public Optional<TipoVehiculo> findByID(@PathVariable("id") Integer id){
        return tipovehiculoservice.findTipoVehiculo(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<TipoVehiculo> newTipoVehiculo(@RequestBody TipoVehiculo tipovehiculo){
        TipoVehiculo obj = tipovehiculoservice.newTipoVehiculo(tipovehiculo);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<TipoVehiculo> editTipoVehiculo(@RequestBody TipoVehiculo tipovehiculo){
        Optional<TipoVehiculo> obj = tipovehiculoservice.findTipoVehiculo(tipovehiculo.getId());
        if(obj.isPresent()){
            obj.get().setId(tipovehiculo.getId());
            obj.get().setNombre(tipovehiculo.getNombre());
            obj.get().setDescripcion(tipovehiculo.getDescripcion());
            tipovehiculoservice.newTipoVehiculo(obj.get());
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TipoVehiculo> deleteTipoVehiculo(@PathVariable("id") Integer id){
        Optional<TipoVehiculo> obj = tipovehiculoservice.findTipoVehiculo(id);
        if (obj.isPresent()){
            tipovehiculoservice.deleteTipoVehiculo(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
