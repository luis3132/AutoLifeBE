package com.autolife.autolife.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autolife.autolife.domain.dto.DuenoNuevo;
import com.autolife.autolife.domain.service.DuenosService;
import com.autolife.autolife.persistence.entity.Duenos;
import com.autolife.autolife.persistence.entity.DuenosPK;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/duenos")
public class DuenosController {
    
    @Autowired
    private DuenosService duenosService;

    @PostMapping("/new")
    public ResponseEntity<Duenos> newDueno(@RequestBody DuenoNuevo duenos) {
        return ResponseEntity.ok(duenosService.save(duenos));
    }

    @PutMapping("/update")
    public ResponseEntity<Duenos> updateDueno(@RequestBody DuenoNuevo duenos) {
        return ResponseEntity.ok(duenosService.update(duenos));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteDueno(@RequestBody DuenosPK id) {
        return ResponseEntity.ok(duenosService.delete(id));
    }
}
