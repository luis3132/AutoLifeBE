package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.VehiculoService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Vehiculo;
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
@RequestMapping("/api/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoservice;
    
    @GetMapping("/list")
    public List<Vehiculo> getVehiculo(){
        return vehiculoservice.getVehiculo();
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Vehiculo> findByID(@PathVariable("id") String numSerie){
        return vehiculoservice.findVehiculo(numSerie)
                .map((Usuarios) -> new ResponseEntity<>(Usuarios, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/list/usuario/{id}")
    public List<Vehiculo> findByUsuario(@PathVariable("id") String usuario){
        return vehiculoservice.findUsuario(usuario);
    }
    
    @PostMapping("/new")
    public ResponseEntity<Vehiculo> newVehiculo(@RequestBody Vehiculo vehiculo){
        if (!vehiculoservice.findVehiculo(vehiculo.getNumSerie()).isPresent()){
            Vehiculo obj = vehiculoservice.newVehiculo(vehiculo);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Vehiculo> editVehiculo(@RequestBody Vehiculo vehiculo){
        Optional<Vehiculo> obj = vehiculoservice.findVehiculo(vehiculo.getNumSerie());
        if (obj.isPresent()){
            obj.get().setCiudadProcedencia(vehiculo.getCiudadProcedencia());
            obj.get().setColor(vehiculo.getColor());
            obj.get().setKilometraje(vehiculo.getKilometraje());
            obj.get().setMarca(vehiculo.getMarca());
            obj.get().setModelo(vehiculo.getModelo());
            obj.get().setNumSerie(vehiculo.getNumSerie());
            obj.get().setPlaca(vehiculo.getPlaca());
            obj.get().setReferencia(vehiculo.getReferencia());
            obj.get().setSerie(vehiculo.getSerie());
            obj.get().setTipovehiculo(vehiculo.getTipovehiculo());
            obj.get().setUsuario(vehiculo.getUsuario());
            vehiculoservice.newVehiculo(obj.get());
            return new ResponseEntity<>(obj.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vehiculo> deleteVehiculo(@PathVariable("id") String numSerie){
        Optional<Vehiculo> obj = vehiculoservice.findVehiculo(numSerie);
        if (obj.isPresent()){
            vehiculoservice.deleteVehiculo(numSerie);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
