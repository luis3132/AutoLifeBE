package com.autolife.autolife.domain.service;

import java.util.List;

import com.autolife.autolife.domain.dto.legislacion.LegislacionEditar;
import com.autolife.autolife.domain.dto.legislacion.LegislacionNueva;
import com.autolife.autolife.persistence.entity.Legislacion;

public interface ILegislacionService {
    List<Legislacion> saveAll(List<LegislacionNueva> legislacion);
    Legislacion update(LegislacionEditar legislacion);
    Boolean delete(Long id);
}
