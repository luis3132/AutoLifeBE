package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Vehiculo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public interface IVehiculoService {
    List<Vehiculo> getVehiculo();
    Vehiculo newVehiculo(Vehiculo vehiculo);
    Optional<Vehiculo> findVehiculo(String num_serie);
    boolean deleteVehiculo(String num_serie);
    List<Vehiculo> findUsuario(String usuario);
    List<Vehiculo> getPublicVehiculo(Boolean publico);
}
