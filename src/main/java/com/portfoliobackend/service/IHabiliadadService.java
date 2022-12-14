package com.portfoliobackend.service;

import java.util.List;

import com.portfoliobackend.entity.Habilidad;

public interface IHabiliadadService {

    public void saveHabilidad(Habilidad habilidad , Long idUsuario) throws Exception;

    public List<Habilidad> getHabilidadList();

    public Habilidad findHabilidad(Long id) throws Exception;

    public void deleteHabilidad(Long id);

    public Habilidad modifyHabilidad(Long idSkill, Habilidad eduacion) throws Exception;
}
