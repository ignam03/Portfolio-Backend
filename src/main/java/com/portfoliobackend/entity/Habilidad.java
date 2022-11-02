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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "habilidades")
@Component
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
public class Habilidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habId;
    @Column(name = "nombre_hab", unique = true)
    private String nombreHab;
    @Column(name = "porcentaje_hab")
    private Integer porcentaje;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    // uso para manejar las referencias bidireccionales hija
    @JsonBackReference
    private Usuario usuario2;

    @Override
    public String toString() {
        return "Habilidad [habId=" + habId + ", nombreHab=" + nombreHab + ", porcentaje=" + porcentaje + "]";
    }

}
