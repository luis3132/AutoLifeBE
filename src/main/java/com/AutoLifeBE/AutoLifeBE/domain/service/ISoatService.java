package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Soat;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface ISoatService {
    Soat newSoatSID(Soat soat);
    boolean deleteSoat(Long id);
    Optional<Soat> findSoat(Long id);
}
