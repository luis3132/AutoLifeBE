package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @Column(name = "num_serie")
    private String numSerie;
    
    @Column(name = "placa")
    private String placa;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "referencia")
    private String referencia;
    
    @Column(name = "serie")
    private String serie;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "kilometraje")
    private Integer kilometraje;
    
    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;

    @ManyToOne
    @JoinColumn(name = "dni", insertable = false, updatable = false)
    private Usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TipoVehiculo tipovehiculo;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<TecnicoMecanica> tecnicomecanica;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Duenos> duenos;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Vehimplicados> vehimplicados;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Mantenimiento> mantenimiento;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Reparacion> reparacion;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Modificacion> modificacion;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Seguro> seguro;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Soat> soat;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Fotos> fotos;
    
    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }
    
}
