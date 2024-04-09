package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Vehiculo;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.VehiculoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Service
@Transactional
public class VehiculoService implements IVehiculoService{
    
    @Autowired
    private VehiculoRepository vehiculorepository;

    @Override
    public List<Vehiculo> getVehiculo() {
        return (List<Vehiculo>) vehiculorepository.findAll();
    }

    @Override
    public Vehiculo newVehiculo(Vehiculo vehiculo) {
        return vehiculorepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> findVehiculo(String num_serie) {
        return vehiculorepository.findById(num_serie);
    }

    @Override
    public boolean deleteVehiculo(String num_serie) {
        if(findVehiculo(num_serie).isPresent()){
            vehiculorepository.deleteById(num_serie);
            return true;
        } else {
            return false;
        }
    }
    
}
