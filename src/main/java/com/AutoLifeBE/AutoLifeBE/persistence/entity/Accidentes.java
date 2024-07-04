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
@Table(name = "accidentes")
public class Accidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "fechaaccidente")
    private Date fechaAccidente;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "coordenadas")
    private String coordenadas;
    
    @Column(name = "costototalestimadodanos")
    private Double costoTotalEstimadoDanos;
    
    @OneToMany(mappedBy = "accidentes")
    private List<Vehimplicados> vehimplicados;
    
    @OneToMany(mappedBy = "accidentes")
    private List<Fotos> fotos;
    
}
