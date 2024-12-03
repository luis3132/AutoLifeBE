package com.autolife.autolife.domain.dto.vehiculo;

import com.autolife.autolife.domain.dto.DuenoNuevo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoCambioDuenoDTO {
    private VehiculoNuevo vehiculo;
    private DuenoNuevo dueno;
}
