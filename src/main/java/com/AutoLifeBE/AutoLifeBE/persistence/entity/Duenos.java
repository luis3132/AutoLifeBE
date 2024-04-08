package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "duenos")
public class Duenos {
    @EmbeddedId
    private DuenosPK id;
    
    @Column(name = "kmstart")
    private Integer kmStart;
    
    @Column(name = "kmfinish")
    private Integer kmFinish;
    
    @Column(name = "datestart")
    private Date dateStart;
    
    @Column(name = "datefinish")
    private Date dateFinish;
    
    @Column(name = "ciudadpromtransi")
    private String ciudadPromTransi;
    
    @ManyToOne
    @JoinColumn(name = "usuarios", insertable = false, updatable = false)
    private Usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name = "vehiculo", insertable = false, updatable = false)
    private Vehiculo vehiculo;

    public DuenosPK getId() {
        return id;
    }

    public void setId(DuenosPK id) {
        this.id = id;
    }

    public Integer getKmStart() {
        return kmStart;
    }

    public void setKmStart(Integer kmStart) {
        this.kmStart = kmStart;
    }

    public Integer getKmFinish() {
        return kmFinish;
    }

    public void setKmFinish(Integer kmFinish) {
        this.kmFinish = kmFinish;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getCiudadPromTransi() {
        return ciudadPromTransi;
    }

    public void setCiudadPromTransi(String ciudadPromTransi) {
        this.ciudadPromTransi = ciudadPromTransi;
    }
}
