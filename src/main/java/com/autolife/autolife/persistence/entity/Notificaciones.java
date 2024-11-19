package com.autolife.autolife.persistence.entity;

import java.util.Date;

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

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private String estado;
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "vehiculo", referencedColumnName = "num_serie")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "servicios", referencedColumnName = "id")
    private Servicios servicios;

    private Date fecha;

    private String taller;
}
