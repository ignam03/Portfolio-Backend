package com.portfoliobackend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educacion")
@Component
@Getter
@Setter
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eduId;
    @Column(name = "titulo_edu")
    private String titulo;
    @Column(name = "nombre_ins")
    private String nombreInstituacion;
    @Column(name = "descripcion_edu")
    private String descripcionEdu;
    @Column(name = "fecha_inicio")
    private int fechaEdu;

    @ManyToOne(
        optional = true,
        fetch = FetchType.EAGER
    )
    private Usuario usuario;


    public Educacion() {
    }

    public Educacion(Long eduId, String titulo, String nombreInstituacion, String descripcionEdu, int fechaEdu) {
        this.eduId = eduId;
        this.titulo = titulo;
        this.nombreInstituacion = nombreInstituacion;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
    }

}
