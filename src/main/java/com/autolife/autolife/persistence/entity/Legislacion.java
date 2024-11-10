package com.autolife.autolife.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "legislacion")
public class Legislacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(name = "date_start")
    private Date fechaInicio;

    @Column(name = "date_finish")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "vehiculo", referencedColumnName = "num_serie")
    @JsonBackReference("vehiculo-legislacion")
    private Vehiculo vehiculo;

    private int kilometraje;

    @ManyToOne
    @Column(name = "tipo_legislacion")
    @JoinColumn(name = "tipo_legislacion", referencedColumnName = "id")
    private TipoLegislacion tipoLegislacion;
}
