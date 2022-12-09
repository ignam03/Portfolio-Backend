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
@Table(name = "educacion")
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "imagen_edu")
    private String imagEdu;
    @Column(name = "fecha_inicio")
    private LocalDate fechaIni;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    // uso para manejar las referencias bidireccionales hija
    @JsonBackReference
    private Usuario usuario;

    @Override
    public String toString() {
        return "Educacion [eduId=" + eduId + ", titulo=" + titulo + ", nombreInstituacion=" + nombreInstituacion
                + ", descripcionEdu=" + descripcionEdu + ", imagEdu=" + imagEdu + ", fechaIni=" + fechaIni
                + ", fechaFin=" + fechaFin + ", usuario=" + usuario + "]";
    }

}
