package com.portfoliobackend.entity;

import java.io.Serializable;

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
    private String titulo;
    private String nombreInstituacion;
    private Integer anio;
    private String descripcionEdu;
    private int fechaEdu;

    public Educacion() {
    }

    public Educacion(Long educacionId, String titulo, String nombreInstituacion, Integer anio, String descripcionEdu,
            int fechaEdu) {
        this.educacionId = educacionId;
        this.titulo = titulo;
        this.nombreInstituacion = nombreInstituacion;
        this.anio = anio;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
    }

    @Override
    public String toString() {
        return "Educacion [anios=" + anio + ", descripcionEdu=" + descripcionEdu + ", educacionId=" + educacionId
                + ", fechaEdu=" + fechaEdu + ", nombreInstituacion=" + nombreInstituacion + ", titulo=" + titulo + "]";
    }

}
