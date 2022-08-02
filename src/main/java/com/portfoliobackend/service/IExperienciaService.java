package com.portfoliobackend.service;

import java.util.List;

import com.portfoliobackend.entity.Experiencia;

public interface IExperienciaService {

    public void saveExperiencia(Experiencia experiencia);

    public List<Experiencia> getExperienciaList();

    public Experiencia findExperiencia(Long id) throws Exception;

    public void deleteExperiencia(Long id);

    public Experiencia modifyExperiencia(Experiencia experiencia) throws Exception;
}
