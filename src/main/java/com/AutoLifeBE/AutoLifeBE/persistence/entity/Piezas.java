package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "piezas")
public class Piezas {
    @Id
    private String id;
    
    private Long pieza;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Mantenimiento mantenimiento;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Reparacion reparacion;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Modificacion modificacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPieza() {
        return pieza;
    }

    public void setPieza(Long pieza) {
        this.pieza = pieza;
    }
}
