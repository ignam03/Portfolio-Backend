package com.portfoliobackend.service;

import java.util.List;

import com.portfoliobackend.entity.Educacion;

public interface IEducacionService {

    public void saveEducacion(Educacion eduacion);

    public List<Educacion> getEducacionList();

    public Educacion findEducacion(Long id) throws Exception;

    public void detectEducacion(Long id);

    public Educacion modifyEducacion(Educacion eduacion) throws Exception;
}
