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
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fechamantenimiento")
    private Date fechaMantenimiento;
    
    @Column(name = "fechaaproxmantenimiento")
    private Date fechaAproxMantenimiento;
    
    @Column(name = "tipomantenimiento")
    private String tipoMantenimiento;
    
    @Column(name = "costomantenimiento")
    private Double costoMantenimiento;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "kilometraje")
    private Integer kilometraje;
    
    @ManyToOne
    @JoinColumn(name = "num_serie", insertable = false, updatable = false)
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TecnicoMecanica tecnicomecanica;
    
    @OneToMany(mappedBy = "mantenimiento")
    private List<Piezas> piezas;
    
    @OneToMany(mappedBy = "mantenimiento")
    private List<Fotos> fotos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Date getFechaAproxMantenimiento() {
        return fechaAproxMantenimiento;
    }

    public void setFechaAproxMantenimiento(Date fechaAproxMantenimiento) {
        this.fechaAproxMantenimiento = fechaAproxMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(Double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
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
