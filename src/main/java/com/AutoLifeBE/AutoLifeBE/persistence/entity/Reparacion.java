package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Andres Gonzalez
 */
@Entity
@Table(name = "reparacion")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fechareparacion")
    private Date fechaReparacion;
    
    @Column(name = "tiporeparacion")
    private String tipoReparacion;
    
    @Column(name = "costoreparacion")
    private Double costoReparacion;
    
    private String descripcion;
    
    private Integer kilometraje;
    
    @ManyToOne
    @JoinColumn(name = "num_serie", insertable = false, updatable = false)
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TecnicoMecanica tecnicomecanica;
    
    @OneToMany(mappedBy = "reparacion")
    private List<Piezas> piezas;
    
    @OneToMany(mappedBy = "reparacion")
    private List<Fotos> fotos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(Date fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public String getTipoReparacion() {
        return tipoReparacion;
    }

    public void setTipoReparacion(String tipoReparacion) {
        this.tipoReparacion = tipoReparacion;
    }

    public Double getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(Double costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    
}
