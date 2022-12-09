package com.portfoliobackend.entity;

import java.io.Serializable;
import java.time.LocalDate;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "experiencias")
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "fecha_inicioExp")
    private LocalDate fechaIniExp;
    @Column(name = "fecha_finExp")
    private LocalDate fechaFinExp;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    // uso para manejar las referencias bidireccionales hija
    @JsonBackReference
    private Usuario usuario1;

    @Override
    public String toString() {
        return "Experiencia [expId=" + expId + ", tituloExp=" + tituloExp + ", descExp=" + descExp + ", imgExp="
                + imgExp + ", fechaIniExp=" + fechaIniExp + ", fechaFinExp=" + fechaFinExp + ", usuario1=" + usuario1
                + "]";
    }

    

    

}
