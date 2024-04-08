package com.AutoLifeBE.AutoLifeBE.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Luis Andres Gonzalez Corzo
 */
@Entity
@Table(name = "fotos")
public class Fotos {
    @Id
    private String id;
    
    private String foto;
    
    private Long piezas;
    
    private Long partes;
    
    @ManyToOne
    @JoinColumn(name = "num_serie", insertable = false, updatable = false)
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Modificacion modificacion;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Reparacion reparacion;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Mantenimiento mantenimiento;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Accidentes accidentes;
    
    @ManyToOne
    @JoinColumn(name = "dni", insertable = false, updatable = false)
    private Usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Soat soat;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Seguro seguro;
    
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TecnicoMecanica tecnicomecanica;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getPiezas() {
        return piezas;
    }

    public void setPiezas(Long piezas) {
        this.piezas = piezas;
    }

    public Long getPartes() {
        return partes;
    }

    public void setPartes(Long partes) {
        this.partes = partes;
    }
    
    
}
