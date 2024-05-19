package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Embeddable
@Data
public class VehimplicadosPK implements Serializable {
    @Column(name = "accidentes")
    private Long accidentes;
    
    @Column(name = "vehiculo")
    private String vehiculo;
    
}
