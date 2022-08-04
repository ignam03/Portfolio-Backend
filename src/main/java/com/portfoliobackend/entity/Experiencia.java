package com.portfoliobackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "experiencias")
@Component
@Getter
@Setter
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expId;
    @Column(name = "titulo_exp", unique = true)
    private String tituloExp;
    @Column(name = "descripcion_exp")
    private String descExp;
    @Column(name = "imagen_exp")
    private String imgExp;
    @Column(name = "fecha_experiencia")
    private int fechaExp;
    

    @ManyToOne(
        optional = true,
        fetch = FetchType.EAGER
    )
    //uso para manejar las referencias bidireccionales hija
    @JsonBackReference
    private Usuario usuario1;

    public Experiencia() {
    }

    public Experiencia(Long expId, String tituloExp, String descExp, String imgExp, int fechaExp) {
        this.expId = expId;
        this.tituloExp = tituloExp;
        this.descExp = descExp;
        this.imgExp = imgExp;
        this.fechaExp = fechaExp;
    }

    @Override
    public String toString() {
        return "Experiencia [descExp=" + descExp + ", expId=" + expId + ", fechaExp=" + fechaExp + ", imgExp=" + imgExp
                + ", tituloExp=" + tituloExp + "]";
    }

}
