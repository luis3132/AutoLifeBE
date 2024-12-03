package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import com.autolife.autolife.domain.dto.vehiculo.VehiculoCambioDuenoDTO;
import com.autolife.autolife.domain.dto.vehiculo.VehiculoNuevo;
import com.autolife.autolife.persistence.entity.Vehiculo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IVehiculosService {
    public List<Vehiculo> findAll();
    public Optional<Vehiculo> findByNumSerie(String numSerie);
    public List<Vehiculo> findByUser(String dni);
    public Vehiculo save(VehiculoNuevo vehiculos);
    public Vehiculo update(VehiculoNuevo vehiculos);
    public Vehiculo updateDueno(VehiculoCambioDuenoDTO vehiculos);
    public Boolean delete(String numSerie);
}
