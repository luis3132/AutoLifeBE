package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.TipoVehiculo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface ITipoVehiculoService {
    List<TipoVehiculo> getTipoVehiculo();
    TipoVehiculo newTipoVehiculo(TipoVehiculo tipovehiculo);
    Optional<TipoVehiculo> findTipoVehiculo(Integer id);
    boolean deleteTipoVehiculo(Integer id);
}
