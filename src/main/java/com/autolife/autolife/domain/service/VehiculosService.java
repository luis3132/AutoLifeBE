package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.VehiculoNuevo;
import com.autolife.autolife.persistence.entity.TipoVehiculo;
import com.autolife.autolife.persistence.entity.Vehiculo;
import com.autolife.autolife.persistence.repository.VehiculoRepository;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Service
public class VehiculosService implements IVehiculosService {
    
    @Autowired
    private VehiculoRepository vehiculosRepository;

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @Override
    public List<Vehiculo> findAll() {
        return vehiculosRepository.findAll();
    }

    @Override
    public List<Vehiculo> findByUser(String dni) {
        return vehiculosRepository.findByUser(dni);
    }

    @Override
    public Optional<Vehiculo> findByNumSerie(String numSerie) {
        return vehiculosRepository.findById(numSerie);
    }

    @Override
    public Vehiculo save(VehiculoNuevo vehiculos) {
        Vehiculo vehiculo = convetDTOtoEntity(vehiculos);
        if (vehiculo != null) {
            return vehiculosRepository.save(vehiculo);
        }
        return null;
    }

    @Override
    public Vehiculo update(VehiculoNuevo vehiculos) {
        if (vehiculosRepository.findById(vehiculos.getNumSerie()).isPresent()) {
            Vehiculo vehiculo = convetDTOtoEntity(vehiculos);
            return vehiculosRepository.save(vehiculo);
        }
        return null;
    }

    @Override
    public Boolean delete(String numSerie) {
        if (vehiculosRepository.findById(numSerie).isPresent()) {
            vehiculosRepository.deleteById(numSerie);
            return true;
        }
        return false;
    }

    private Vehiculo convetDTOtoEntity(VehiculoNuevo vehiculos) {
        Vehiculo vehiculo = new Vehiculo();
        Optional<TipoVehiculo> tipoVehiculo = tipoVehiculoService.findById(vehiculos.getTipoVehiculo());

        vehiculo.setNumSerie(vehiculos.getNumSerie());
        vehiculo.setPlaca(vehiculos.getPlaca());
        vehiculo.setMarca(vehiculos.getMarca());
        vehiculo.setModelo(vehiculos.getModelo());
        vehiculo.setReferencia(vehiculos.getReferencia());
        vehiculo.setSerie(vehiculos.getSerie());
        vehiculo.setColor(vehiculos.getColor());
        vehiculo.setUsuario(vehiculos.getUsuario());
        vehiculo.setKilometraje(vehiculos.getKilometraje());
        vehiculo.setCiudadProcedencia(vehiculos.getCiudadProcedencia());
        vehiculo.setPublico(vehiculos.getPublico());
        vehiculo.setDescripcion(vehiculos.getDescripcion());

        if (tipoVehiculo.isPresent()) {
            vehiculo.setTipoVehiculo(tipoVehiculo.get());
            return vehiculo;
        } else {
            return null;
        }
    }

}
