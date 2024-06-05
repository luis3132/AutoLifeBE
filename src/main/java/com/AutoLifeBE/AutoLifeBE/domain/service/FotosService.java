package com.AutoLifeBE.AutoLifeBE.domain.service;

import com.AutoLifeBE.AutoLifeBE.persistence.entity.Fotos;
import com.AutoLifeBE.AutoLifeBE.persistence.repository.FotosRepository;
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
public class FotosService implements IFotosService{
    
    @Autowired
    private FotosRepository fotosRepository;

    @Override
    public Fotos newFoto(Fotos foto) {
        return fotosRepository.save(foto);
    }

    @Override
    public boolean deleteFoto(String id) {
        if(findFoto(id).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Fotos> findFoto(String id) {
        return fotosRepository.findById(id);
    }
    
}
