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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "habilidades")
@Component
@Getter
@Setter
public class Habilidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habId;
    @Column(name = "nombre_hab", unique = true)
    private String nombreHab;
    @Column(name = "porcentaje_hab")
    private String porcentaje;

    @ManyToOne(
        optional = true,
        fetch = FetchType.EAGER
    )
    private Usuario usuario2;

    public Habilidad() {
    }

    public Habilidad(Long habId, String nombreHab, String porcentaje) {
        this.habId = habId;
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Habilidad [habId=" + habId + ", nombreHab=" + nombreHab + ", porcentaje=" + porcentaje + "]";
    }

}
