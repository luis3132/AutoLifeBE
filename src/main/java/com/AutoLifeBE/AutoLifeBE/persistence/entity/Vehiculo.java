package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Andres Gonzalez Corzo
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
    private String marca;
    private String modelo;
    private String referencia;
    private String serie;
    private String color;
    private Integer kilometraje;
    private Boolean publico;
    private String descripcion;
    
    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;

    private String usuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipovehiculo", referencedColumnName = "id")
    private TipoVehiculo tipovehiculo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Fotos> fotos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Duenos> duenos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Seguro> seguro;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Soat> soat;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<TecnicoMecanica> tecnicoMecanica;

}
