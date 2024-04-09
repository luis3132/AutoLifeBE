package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @Column(name = "num_serie")
    private String numSerie;
    private String placa;
    private String marca;
    private String modelo;
    private String referencia;
    private String serie;
    private String color;
    private Integer kilometraje;
    
    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;

    private String usuario;
    private Integer tipovehiculo;

}
