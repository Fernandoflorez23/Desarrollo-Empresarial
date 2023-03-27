package com.usta.empresarialfull.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "directores")
public class directorEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddirector")
    private Long iddirector;

    @NotNull
    @Size(min=1,max=30)
    @Column(name = "nombres")
    private String nombres;

    @NotNull
    @Size(min=1,max=30)
    @Column(name = "apellidos")
    private String apellidos;

    @NotNull
    @Size(min=1,max=30)
    @Column(name = "calificacion")
    private Float calificacion;

    @OneToOne
    @JoinColumn(name = "iduniversidad")
    private universidadEntity iduniversidad;
}
