package com.portfoliobackend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Component
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Experiencia> experiencias;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Educacion> educacion;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Habilidad> habilidades;

    public Usuario() {
    }

    public Usuario(Long userId, String nombre, String apellido, String descripcion, String titulo, String fotoPerfil) {
        this.userId = userId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Usuario [apellido=" + apellido + ", descripcion=" + descripcion + ", fotoPerfil=" + fotoPerfil
                + ", nombre=" + nombre + ", titulo=" + titulo + ", userId=" + userId + "]";
    }

}
