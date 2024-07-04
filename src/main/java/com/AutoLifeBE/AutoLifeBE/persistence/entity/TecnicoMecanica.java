package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tecnicomecanica")
public class TecnicoMecanica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "kilometraje")
    private Integer kilometraje;
    
    @Column(name = "datestart")
    private Date dateStart;
    
    @Column(name = "datefinish")
    private Date dateFinish;
    
    @Column(name = "vehiculo")
    private String vehiculo;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Mantenimiento> mantenimiento;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Reparacion> reparacion;
    
    @OneToMany(mappedBy = "tecnicomecanica")
    private List<Fotos> fotos;    
}
