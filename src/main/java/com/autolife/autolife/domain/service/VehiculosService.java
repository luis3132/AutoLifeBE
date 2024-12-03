package com.autolife.autolife.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.autolife.autolife.domain.dto.DuenoNuevo;
import com.autolife.autolife.domain.dto.vehiculo.VehiculoCambioDuenoDTO;
import com.autolife.autolife.domain.dto.vehiculo.VehiculoNuevo;
import com.autolife.autolife.persistence.entity.DuenosPK;
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

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    @Lazy
    private DuenosService duenosService;

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
    public List<Vehiculo> findPublicVehiculo() {
        return vehiculosRepository.findByPublico(true);
    }

    @Override
    public Vehiculo save(VehiculoNuevo vehiculos) {
        DuenoNuevo dueno = createDueno(vehiculos);
        Vehiculo vehiculo = convetDTOtoEntity(vehiculos);
        if (vehiculo != null) {
            Vehiculo created = vehiculosRepository.save(vehiculo);
            duenosService.save(dueno);
            return created;
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
    public Vehiculo updateDueno(VehiculoCambioDuenoDTO vehiculos) {
        if (usuariosService.findByUsuario(vehiculos.getVehiculo().getUsuario()).isPresent()) {
            if (vehiculosRepository.findById(vehiculos.getVehiculo().getNumSerie()).isPresent()) {
                DuenoNuevo viejo = setUpdateDueno(vehiculos.getDueno());
                DuenoNuevo nuevo = createDueno(vehiculos.getVehiculo());
                Vehiculo vehiculo = convetDTOtoEntity(vehiculos.getVehiculo());
                duenosService.update(viejo);
                duenosService.save(nuevo);
                return vehiculosRepository.save(vehiculo);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(String numSerie) {
        Optional<Vehiculo> vehiculo = vehiculosRepository.findById(numSerie);
        DuenosPK duenoPK = new DuenosPK(vehiculo.get().getNumSerie(), vehiculo.get().getUsuario());
        if (vehiculo.isPresent()) {
            if (duenosService.delete(duenoPK)) {
                vehiculosRepository.deleteById(numSerie);
                return true;
            }
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
        vehiculo.setFechaCompra(vehiculos.getFechaCompra());
        vehiculo.setCiudadPromTransi(vehiculos.getCiudadPromTransi());

        if (tipoVehiculo.isPresent()) {
            vehiculo.setTipoVehiculo(tipoVehiculo.get());
            return vehiculo;
        } else {
            return null;
        }
    }

    private DuenoNuevo createDueno(VehiculoNuevo vehiculos) {
        DuenoNuevo dueno = new DuenoNuevo();
        dueno.setVehiculo(vehiculos.getNumSerie());
        dueno.setUsuario(vehiculos.getUsuario());
        dueno.setKmStart(0);
        dueno.setDateStart(vehiculos.getFechaCompra());
        dueno.setCiudadPromTransi(vehiculos.getCiudadPromTransi());
        return dueno;
    }

    private DuenoNuevo setUpdateDueno(DuenoNuevo duenoNuevo) {
        DuenoNuevo dueno = new DuenoNuevo();
        dueno.setVehiculo(duenoNuevo.getUsuario());
        dueno.setUsuario(duenoNuevo.getUsuario());
        dueno.setKmStart(duenoNuevo.getKmStart());
        dueno.setDateStart(duenoNuevo.getDateStart());
        dueno.setKmFinish(duenoNuevo.getKmFinish());
        dueno.setDateFinish(duenoNuevo.getDateFinish());
        dueno.setCiudadPromTransi(duenoNuevo.getCiudadPromTransi());
        return dueno;
    }

}
