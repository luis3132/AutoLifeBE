package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import com.autolife.autolife.domain.dto.servicios.ServicioEditar;
import com.autolife.autolife.domain.dto.servicios.ServicioNuevo;
import com.autolife.autolife.persistence.entity.Servicios;

public interface IServiciosService {
    Optional<Servicios> findById(Long id);
    List<Servicios> saveAll(List<ServicioNuevo> servicios);
    Servicios update(ServicioEditar servicio);
    Boolean delete(Long id);
}
