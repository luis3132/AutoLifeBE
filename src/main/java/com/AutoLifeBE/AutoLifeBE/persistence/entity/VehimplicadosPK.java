package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Embeddable
public class VehimplicadosPK implements Serializable {
    @Column(name = "accidentes")
    private Long accidentes;
    
    @Column(name = "vehiculo")
    private String vehiculo;

    public Long getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(Long accidentes) {
        this.accidentes = accidentes;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
