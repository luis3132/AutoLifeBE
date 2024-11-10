package com.autolife.autolife.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "duenos")
public class Duenos {
    @EmbeddedId
    private DuenosPK duenosPK;

    @Column(name = "kmstart")
    private Integer kmStart;

    @Column(name = "kmfinish")
    private Integer kmFinish;

    @Column(name = "datestart")
    private Date dateStart;

    @Column(name = "datefinish")
    private Date dateFinish;

    @Column(name = "ciudadpromtransi")
    private String ciudadPromTransi;

    @ManyToOne
    @MapsId("vehiculo")
    @JsonBackReference("vehiculo-duenos")
    @JoinColumn(name = "vehiculo", referencedColumnName = "num_serie")
    private Vehiculo vehiculo;

    @ManyToOne
    @MapsId("usuario")
    @JoinColumn(name = "usuario", referencedColumnName = "dni")
    private Usuarios usuario;

}
