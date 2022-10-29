package com.portfoliobackend.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // uso para manejar las referencias bidireccionales padre
    @JsonManagedReference
    private List<Educacion> educacionList;

    @OneToMany(mappedBy = "usuario1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // uso para manejar las referencias bidireccionales padre
    @JsonManagedReference
    private Set<Experiencia> experienciaList;

    @OneToMany(mappedBy = "usuario2", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // uso para manejar las referencias bidireccionales padre
    @JsonManagedReference
    private Set<Habilidad> habilidadList;

    @Override
    public String toString() {
        return "Usuario [apellido=" + apellido + ", descripcion=" + descripcion + ", fotoPerfil=" + fotoPerfil
                + ", nombre=" + nombre + ", titulo=" + titulo + ", userId=" + userId + "]";
    }

}
