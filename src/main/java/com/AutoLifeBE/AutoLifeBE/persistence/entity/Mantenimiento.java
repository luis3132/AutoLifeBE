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
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "fechamantenimiento")
    private Date fechaMantenimiento;
    
    @Column(name = "fechaaproxmantenimiento")
    private Date fechaAproxMantenimiento;
    
    @Column(name = "tipomantenimiento")
    private String tipoMantenimiento;
    
    @Column(name = "costomantenimiento")
    private Double costoMantenimiento;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "kilometraje")
    private Integer kilometraje;
    
    @Column(name = "vehiculo")
    private String vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TecnicoMecanica tecnicomecanica;
    
    @OneToMany(mappedBy = "mantenimiento")
    private List<Piezas> piezas;
    
    @OneToMany(mappedBy = "mantenimiento")
    private List<Fotos> fotos;
    
}
