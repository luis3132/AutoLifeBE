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
 * @author Luis Andres Gonzalez
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reparacion")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "fechareparacion")
    private Date fechaReparacion;
    
    @Column(name = "tiporeparacion")
    private String tipoReparacion;
    
    @Column(name = "costoreparacion")
    private Double costoReparacion;
    
    private String descripcion;
    
    private Integer kilometraje;
    
    @Column(name = "vehiculo")
    private String vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TecnicoMecanica tecnicomecanica;
    
    @OneToMany(mappedBy = "reparacion")
    private List<Piezas> piezas;
    
    @OneToMany(mappedBy = "reparacion")
    private List<Fotos> fotos;   
    
}
