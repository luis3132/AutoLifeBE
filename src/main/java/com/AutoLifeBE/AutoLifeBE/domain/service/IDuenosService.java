package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Duenos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface IDuenosService {
    List<Duenos> getDuenos();
    Duenos newDuenos(Duenos duenos);
    Optional<List<Duenos>> findDuenosByIdUsuario(String usuario);
    Optional<List<Duenos>> findDuenosByIdVehiculo(String vehiculo);
    Optional<Duenos> findDueno(Long id);
    boolean deleteDuenos(Long id);
}
