package com.AutoLifeBE.AutoLifeBE.domain.controller;

import com.AutoLifeBE.AutoLifeBE.domain.service.DuenosService;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Duenos;
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
@RequestMapping("/api/duenos")
public class DuenosController {
    @Autowired
    private DuenosService duenosservice;
    
    @GetMapping("/list")
    public List<Duenos> getDuenos(){
        return duenosservice.getDuenos();
    }
    
    @GetMapping("/list/usuario/{id}")
    public ResponseEntity<List<Duenos>> findByUsuarios(@PathVariable("id") String usuario){
        return duenosservice.findDuenosByIdUsuario(usuario)
                .map((Duenos) -> new ResponseEntity<>(Duenos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/list/vehiculo/{id}")
    public ResponseEntity<List<Duenos>> findByVehiculos(@PathVariable("id") String vehiculo){
        return duenosservice.findDuenosByIdVehiculo(vehiculo)
                .map((Duenos) -> new ResponseEntity<>(Duenos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Duenos> findByID(@PathVariable("id") Long id){
        return duenosservice.findDueno(id)
                .map((Duenos) -> new ResponseEntity<>(Duenos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/new")
    public ResponseEntity<Duenos> newDueno(@RequestBody Duenos duenos){
        if (!duenosservice.findDueno(duenos.getId()).isPresent()){
            Duenos obj = duenosservice.newDuenos(duenos);
            return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Duenos> editDuenos(@RequestBody Duenos duenos){
        Optional<Duenos> obj = duenosservice.findDueno(duenos.getId());
        if (obj.isPresent()){
            obj.get().setCiudadPromTransi(duenos.getCiudadPromTransi());
            obj.get().setDateFinish(duenos.getDateFinish());
            obj.get().setDateStart(duenos.getDateStart());
            obj.get().setId(duenos.getId());
            obj.get().setKmFinish(duenos.getKmFinish());
            obj.get().setKmStart(duenos.getKmStart());
            duenosservice.newDuenos(obj.get());
            return new ResponseEntity<>(obj.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Duenos> deleteDuenos(@PathVariable("id") Long id){
        Optional<Duenos> obj = duenosservice.findDueno(id);
        if (obj.isPresent()){
            duenosservice.deleteDuenos(id);
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
