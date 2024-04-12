package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.TipoVehiculo;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.TipoVehiculoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
public class TipoVehiculoService implements ITipoVehiculoService {
    @Autowired
    private TipoVehiculoRepository tipovehiculorespository;
    
    @Override
    public List<TipoVehiculo> getTipoVehiculo() {
        return (List<TipoVehiculo>) tipovehiculorespository.findAll();
    }

    @Override
    public TipoVehiculo newTipoVehiculo(TipoVehiculo tipovehiculo) {
        return tipovehiculorespository.save(tipovehiculo);
    }

    @Override
    public Optional<TipoVehiculo> findTipoVehiculo(Integer id) {
        return tipovehiculorespository.findById(id);
    }

    @Override
    public boolean deleteTipoVehiculo(Integer id) {
        if (findTipoVehiculo(id).isPresent()){
            tipovehiculorespository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
