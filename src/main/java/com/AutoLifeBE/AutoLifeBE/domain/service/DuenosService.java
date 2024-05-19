package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.domain.dto.DuenosDTO;
import com.AutoLifeBE.AutoLifeBE.persistence.entity.Duenos;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.DuenosRepository;
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
public class DuenosService implements IDuenosService {

    @Autowired
    private DuenosRepository duenosrepository;

    @Override
    public List<Duenos> getDuenos() {
        return (List<Duenos>) duenosrepository.findAll();
    }

    @Override
    public Duenos newDuenos(Duenos duenos) {
        return duenosrepository.save(duenos);
    }

    @Override
    public Optional<List<Duenos>> findDuenosByIdUsuario(String usuario) {
        return duenosrepository.findByIdUsuarios(usuario);
    }

    @Override
    public Optional<List<Duenos>> findDuenosByIdVehiculo(String vehiculo) {
        return duenosrepository.findByIdVehiculos(vehiculo);
    }

    @Override
    public boolean deleteDuenos(Long id) {
        if (findDueno(id).isPresent()) {
            duenosrepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Duenos> findDueno(Long id) {
        return duenosrepository.findById(id);
    }

    @Override
    public void newDuenosSID(DuenosDTO duenos) {
        duenosrepository.saveSID(duenos.getUsuario(), duenos.getVehiculo(), duenos.getKmStart(), duenos.getKmFinish(), duenos.getDateStart(), duenos.getDateFinish(), duenos.getCiudadPromTransi());
    }

}
