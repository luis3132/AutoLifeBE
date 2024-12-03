package com.autolife.autolife.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @Column(name = "num_serie")
    private String numSerie;

    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo", referencedColumnName = "id")
    private TipoVehiculo tipoVehiculo;

    private String marca;
    private String modelo;
    private String referencia;
    private String serie;
    private String color;
    private String usuario;
    private Integer kilometraje;

    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;

    private Boolean publico;
    private String descripcion;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "ciudadpromtransi")
    private String ciudadPromTransi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Fotos> fotos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    @JsonManagedReference("vehiculo-legislacion")
    private List<Legislacion> legislacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    @JsonManagedReference("vehiculo-servicios")
    private List<Servicios> servicios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    @JsonManagedReference("vehiculo-duenos")
    private List<Duenos> duenos;
}
