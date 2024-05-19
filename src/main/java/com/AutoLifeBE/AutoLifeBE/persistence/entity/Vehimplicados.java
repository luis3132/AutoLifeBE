package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Data
@Table(name = "vehimplicados")
public class Vehimplicados {
    @EmbeddedId
    private VehimplicadosPK id;
    
    @Column(name = "piezas_afectadas")
    private String piezasAfectadas;
    
    @Column(name = "costoestimadoreparacion")
    private Double costoestimadoreparacion;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Accidentes accidentes;
    
    @ManyToOne
    @JoinColumn(name = "num_serie", insertable = false, updatable = false)
    private Vehiculo vehiculo;
    
}
