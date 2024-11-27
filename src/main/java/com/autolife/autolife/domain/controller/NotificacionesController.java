package com.autolife.autolife.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.notificacion.NotificacionEditarDTO;
import com.autolife.autolife.domain.dto.notificacion.NotificacionNuevaDTO;
import com.autolife.autolife.domain.service.NotificacionesService;
import com.autolife.autolife.persistence.entity.Notificaciones;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/notificaciones")
public class NotificacionesController {
    
    @Autowired
    private NotificacionesService notificacionesService;

    @GetMapping("/list/usuario/{dni}")
    @Secured({"USER"})
    public ResponseEntity<List<Notificaciones>> getListByUser(@PathVariable("dni") String dni) {
        return ResponseEntity.ok(notificacionesService.findByUser(dni));
    }

    @GetMapping("/list/taller/{dni}")
    @Secured({"TALLER"})
    public ResponseEntity<List<Notificaciones>> getListByTaller(@PathVariable("dni") String dni) {
        return ResponseEntity.ok(notificacionesService.findByTaller(dni));
    }

    @PostMapping("/new")
    public ResponseEntity<Notificaciones> saveNotificacion(@RequestBody NotificacionNuevaDTO notificacion) {
        return ResponseEntity.ok(notificacionesService.save(notificacion));
    }

    @PutMapping("/update")
    public ResponseEntity<Notificaciones> updateNotificacion(@RequestBody NotificacionEditarDTO notificacion) {
        return ResponseEntity.ok(notificacionesService.update(notificacion));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNotificacion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(notificacionesService.delete(id));
    }
    
}
