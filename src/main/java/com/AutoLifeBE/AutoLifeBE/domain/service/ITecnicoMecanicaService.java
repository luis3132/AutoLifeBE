package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.TecnicoMecanica;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface ITecnicoMecanicaService {
    TecnicoMecanica newTecnicoMecanica(TecnicoMecanica tecnicoMecanica);
    boolean deleteTecnicoMecanica(Long id);
    Optional<TecnicoMecanica> findTecnicoMecanica(Long id);
}
