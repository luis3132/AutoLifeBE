package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "modificacion")
public class Modificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fechamodificacion")
    private Date fechaModificacion;
    
    @Column(name = "tipomodificacion")
    private String tipoModificacion;
    
    @Column(name = "costomodificaion")
    private Double costoModificaion;
    
    private String descripcion;
    
    private Integer kilometraje;
    
    @ManyToOne
    @JoinColumn(name = "num_serie")
    private Vehiculo vehiculo;
    
    @OneToMany(mappedBy = "modificacion")
    private List<Piezas> piezas;
    
    @OneToMany(mappedBy = "modificacion")
    private List<Fotos> fotos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getTipoModificacion() {
        return tipoModificacion;
    }

    public void setTipoModificacion(String tipoModificacion) {
        this.tipoModificacion = tipoModificacion;
    }

    public Double getCostoModificaion() {
        return costoModificaion;
    }

    public void setCostoModificaion(Double costoModificaion) {
        this.costoModificaion = costoModificaion;
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
