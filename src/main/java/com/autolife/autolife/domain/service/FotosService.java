package com.autolife.autolife.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.autolife.autolife.domain.dto.FotosNuevo;
import com.autolife.autolife.persistence.entity.Fotos;
import com.autolife.autolife.persistence.repository.FotosRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class FotosService implements IFotosService {
     
    @Autowired
    private FotosRepository fotosRepository;

    @Override
    public Optional<Fotos> findById(Long id) {
        return fotosRepository.findById(id);
    }

    @Override
    public Fotos save(FotosNuevo fotos) {
        return fotosRepository.save(convertDTOtoEntity(fotos));
    }

    @Override
    public Boolean delete(Long id) {
        if (fotosRepository.findById(id).isPresent()) {
            fotosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String uploadImage(MultipartFile file, FotosNuevo fotos) {
        if (file.isEmpty()) {
            return "File is empty";
        }
        try {
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return "File is not an image";
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);

            fotos.setPath(path.toString());

            save(fotos);
            
            return "File uploaded successfully: " + path.toString();
        } catch (IOException e) {
            return "Failed to upload file";
        }
    }

    private static final String UPLOAD_DIR = "uploads/";

    private Fotos convertDTOtoEntity(FotosNuevo fotos) {
        Fotos entity = new Fotos();

        entity.setPath(fotos.getPath());
        entity.setVehiculo(fotos.getVehiculo());
        entity.setServicio(fotos.getServicio());
        entity.setAccidentes(fotos.getAccidentes());
        entity.setUsuarios(fotos.getUsuarios());
        entity.setLegislacion(fotos.getLegislacion());
        entity.setPiezas(fotos.getPiezas());
        entity.setPartes(fotos.getPartes());

        return entity;
    }
}
