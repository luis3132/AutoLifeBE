package com.autolife.autolife.persistence.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @Column(name = "fecha_proximo")
    private Date fechaProximo;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio", referencedColumnName = "id")
    private TipoServicio tipoServicio;

    @Column(name = "costo_servicio")
    private Integer costoServicio;

    private String descripcion;
    private Integer kilometraje;

    @ManyToOne
    @JoinColumn(name = "vehiculo", referencedColumnName = "num_serie")
    @JsonBackReference("vehiculo-servicios")
    private Vehiculo vehiculo;

}
