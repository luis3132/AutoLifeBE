package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "duenos")
public class Duenos {
    @Id
    private Long id;
    
    private String usuario;
    private String vehiculo;
    
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
    
}
