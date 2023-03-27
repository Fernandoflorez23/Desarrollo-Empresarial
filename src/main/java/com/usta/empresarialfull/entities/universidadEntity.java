package com.usta.empresarialfull.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "universidades")
public class universidadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduniversidad")
    private Long iduniversidad;

    @NotNull
    @Size(min=1, max = 13)
    @Column(name = "nit",unique = true)
    private String nit;

    @NotNull
    @Size(min=1,max=30)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "fechafundacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaFundacion;

    @NotNull
    @Size(min=1,max=20)
    @Column(name="direccion")
    private String direccion;

    @NotNull
    @Size(min=1,max=20)
    @Column(name="telefono")
    private String telefono;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @OneToOne(mappedBy = "iduniversidad")
    private directorEntity iddirector;

    public Long getIduniversidad() {
        return iduniversidad;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
