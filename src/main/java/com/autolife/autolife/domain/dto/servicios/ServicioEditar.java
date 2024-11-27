package com.autolife.autolife.domain.dto.servicios;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioEditar {
    private Long id;
    private Date fecha;
    private Date fechaProximo;
    private Integer tipoServicio;
    private Integer costoServicio;
    private String descripcion;
    private Integer kilometraje;
    private String vehiculo;
    private String mecanico;
    private String estado;
}
