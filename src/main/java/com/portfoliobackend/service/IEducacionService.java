package com.portfoliobackend.service;

import java.util.List;

import com.portfoliobackend.entity.Educacion;

public interface IEducacionService {

    public void saveEducacion(Educacion eduacion);

    public List<Educacion> getEducacionList();

    public Educacion findEducacion(Long id) throws Exception;

    public void deleteEducacion(Long id);

    public Educacion modifyEducacion(Long idEdu, Educacion eduacion) throws Exception;
}
