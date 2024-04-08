package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
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

    public VehimplicadosPK getId() {
        return id;
    }

    public void setId(VehimplicadosPK id) {
        this.id = id;
    }

    public String getPiezasAfectadas() {
        return piezasAfectadas;
    }

    public void setPiezasAfectadas(String piezasAfectadas) {
        this.piezasAfectadas = piezasAfectadas;
    }

    public Double getCostoestimadoreparacion() {
        return costoestimadoreparacion;
    }

    public void setCostoestimadoreparacion(Double costoestimadoreparacion) {
        this.costoestimadoreparacion = costoestimadoreparacion;
    }
    
}
