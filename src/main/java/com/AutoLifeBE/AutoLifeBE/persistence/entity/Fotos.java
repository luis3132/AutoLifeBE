package com.AutoLifeBE.AutoLifeBE.persistence.entity;

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
@Table(name = "fotos")
public class Fotos {
    @Id
    private String id;
    
    private String foto;
    private Long piezas;
    private Long partes;
    private String vehiculo;
    private String modificacion;
    private String reparacion;
    private String mantenimiento;
    private String accidentes;
    private String usuarios;
    private String soat;
    private String seguro;
    private String tecnicomecanica;
}
