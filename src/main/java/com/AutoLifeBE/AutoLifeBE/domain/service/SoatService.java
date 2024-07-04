package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Soat;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.SoatRepository;
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
public class SoatService implements ISoatService {

    @Autowired
    private SoatRepository soatRepository;

    @Override
    public Soat newSoatSID(Soat soat) {
        return soatRepository.save(soat);
    }

    @Override
    public boolean deleteSoat(String id) {
        if (findSoat(id).isPresent()) {
            soatRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Soat> findSoat(String id) {
        return soatRepository.findById(id);
    }

}
