package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Fotos;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface IFotosService {
    Fotos newFoto(Fotos foto);
    boolean deleteFoto(String id);
    Optional<Fotos> findFoto(String id);
}
