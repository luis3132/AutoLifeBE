package com.autolife.autolife.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoNuevo {
    private String numSerie;
    private String placa;
    private Integer tipoVehiculo;
    private String marca;
    private String modelo;
    private String referencia;
    private String serie;
    private String color;
    private String usuario;
    private Integer kilometraje;
    private String ciudadProcedencia;
    private Boolean publico;
    private String descripcion;
}
