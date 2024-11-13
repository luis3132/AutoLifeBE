package com.autolife.autolife.domain.dto;

import java.util.Date;

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
public class DuenoNuevo {
    private String usuario;
    private String vehiculo;
    private Integer kmStart;
    private Integer kmFinish;
    private Date dateStart;
    private Date dateFinish;
    private String ciudadPromTransi;
}
