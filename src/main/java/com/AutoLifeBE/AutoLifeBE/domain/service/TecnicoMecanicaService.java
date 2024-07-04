package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.TecnicoMecanica;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.TecnicoMecanicaRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Service
@Transactional
public class TecnicoMecanicaService implements ITecnicoMecanicaService {

    @Autowired
    private TecnicoMecanicaRepository tecnicoMecanicaRepository;

    @Override
    public boolean deleteTecnicoMecanica(String id) {
        if (findTecnicoMecanica(id).isPresent()) {
            tecnicoMecanicaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<TecnicoMecanica> findTecnicoMecanica(String id) {
        return tecnicoMecanicaRepository.findById(id);
    }

    @Override
    public TecnicoMecanica newTecnicoMecanica(TecnicoMecanica tecnicoMecanica) {
        return tecnicoMecanicaRepository.save(tecnicoMecanica);
    }

}
