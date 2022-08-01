package com.portfoliobackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eduacion")
@Component
@Getter
@Setter
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educacionId;
    @Column(name = "titulo_edu")
    private String titulo;
    @Column(name = "nombre_ins")
    private String nombreInstituacion;
    @Column(name = "descripcion_edu")
    private String descripcionEdu;
    @Column(name = "fehca_inicio")
    private int fechaEdu;

    public Educacion() {
    }

    public Educacion(Long educacionId, String titulo, String nombreInstituacion, String descripcionEdu, int fechaEdu) {
        this.educacionId = educacionId;
        this.titulo = titulo;
        this.nombreInstituacion = nombreInstituacion;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
    }

    

}
