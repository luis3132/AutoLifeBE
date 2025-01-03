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

import com.autolife.autolife.domain.dto.notificacion.NotificacionServicioNuevosDTO;
import com.autolife.autolife.domain.dto.servicios.ServicioEditar;
import com.autolife.autolife.domain.dto.servicios.ServicioNuevo;
import com.autolife.autolife.domain.service.NotificacionesService;
import com.autolife.autolife.domain.service.ServiciosService;
import com.autolife.autolife.domain.service.TipoServicioService;
import com.autolife.autolife.persistence.entity.Servicios;
import com.autolife.autolife.persistence.entity.TipoServicio;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/servicios")
public class ServiciosController {
    
    @Autowired
    private ServiciosService serviciosService;

    @Autowired
    private TipoServicioService tipoServicioService;

    @Autowired
    private NotificacionesService notificacionesService;

    @GetMapping("/list/tiposervicio")
    public ResponseEntity<List<TipoServicio>> listTipoServicio() {
        return ResponseEntity.ok(tipoServicioService.findAll());
    }

    @PostMapping("/new/notificacion")
    public ResponseEntity<Boolean> save(@RequestBody NotificacionServicioNuevosDTO servicio) {
        return ResponseEntity.ok(notificacionesService.saveNyS(servicio));
    }

    @PostMapping("/new")
    public ResponseEntity<List<Servicios>> saveAll(@RequestBody List<ServicioNuevo> servicios) {
        return ResponseEntity.ok(serviciosService.saveAll(servicios));
    }

    @PutMapping("/update")
    public ResponseEntity<Servicios> update(@RequestBody ServicioEditar servicio) {
        return ResponseEntity.ok(serviciosService.update(servicio));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviciosService.delete(id));
    }
}
