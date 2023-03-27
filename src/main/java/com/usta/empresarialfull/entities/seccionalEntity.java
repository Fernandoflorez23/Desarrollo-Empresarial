package com.usta.empresarialfull.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "seccionales")
public class seccionalEntity implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseccional")
    private Long idseccional;

    @NotNull
    @Size(min = 1, max= 30)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "cantidadfacultades")
    private Integer cantidadfacultades;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @JoinColumn(name = "iduniversidad", referencedColumnName = "iduniversidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private universidadEntity iduniversidad;

    public Long getIdseccional() {
        return idseccional;
    }

    public void setIdseccional(Long idseccional) {
        this.idseccional = idseccional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadfacultades() {
        return cantidadfacultades;
    }

    public void setCantidadfacultades(Integer cantidadfacultades) {
        this.cantidadfacultades = cantidadfacultades;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public universidadEntity getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(universidadEntity iduniversidad) {
        this.iduniversidad = iduniversidad;
    }
}
