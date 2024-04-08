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

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "tecnicomecanica")
public class TecnicoMecanica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "kilometraje")
    private Integer kilometraje;
    
    @Column(name = "datestart")
    private Date dateStart;
    
    @Column(name = "datefinish")
    private Date dateFinish;
    
    @ManyToOne
    @JoinColumn(name = "num_serie")
    private Vehiculo vehiculo;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Mantenimiento> mantenimiento;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Reparacion> reparacion;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Fotos> fotos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }
    
    
}
