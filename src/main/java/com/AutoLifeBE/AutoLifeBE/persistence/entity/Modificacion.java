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
@Table(name = "modificacion")
public class Modificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
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

}
