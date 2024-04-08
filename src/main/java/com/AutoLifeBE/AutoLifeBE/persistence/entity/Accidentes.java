package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "accidentes")
public class Accidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fechaaccidente")
    private Date fechaAccidente;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "coordenadas")
    private String coordenadas;
    
    @Column(name = "costototalestimadodanos")
    private Double costoTotalEstimadoDanos;
    
    @OneToMany(mappedBy = "accidentes")
    private List<Vehimplicados> vehimplicados;
    
    @OneToMany(mappedBy = "accidentes")
    private List<Fotos> fotos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAccidente() {
        return fechaAccidente;
    }

    public void setFechaAccidente(Date fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Double getCostoTotalEstimadoDanos() {
        return costoTotalEstimadoDanos;
    }

    public void setCostoTotalEstimadoDanos(Double costoTotalEstimadoDanos) {
        this.costoTotalEstimadoDanos = costoTotalEstimadoDanos;
    }
    
    
}
