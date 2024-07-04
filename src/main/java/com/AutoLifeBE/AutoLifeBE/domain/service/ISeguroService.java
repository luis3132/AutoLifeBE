package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Seguro;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface ISeguroService {
    Seguro newSeguro(Seguro seguro);
    boolean deleteSeguro(String id);
    Optional<Seguro> findSeguro(String id);
}
