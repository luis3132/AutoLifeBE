package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Seguro;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.SeguroRepository;
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
public class SeguroService implements ISeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public boolean deleteSeguro(Long id) {
        if (findSeguro(id).isPresent()) {
            seguroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Seguro> findSeguro(Long id) {
        return seguroRepository.findById(id);
    }

    @Override
    public Seguro newSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

}
