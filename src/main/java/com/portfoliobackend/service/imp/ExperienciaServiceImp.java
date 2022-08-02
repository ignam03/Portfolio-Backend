package com.portfoliobackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Experiencia;
import com.portfoliobackend.repository.ExperienciaRepository;
import com.portfoliobackend.service.IExperienciaService;

@Service("ExperienciaServiceImp")
public class ExperienciaServiceImp implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);

    }

    @Override
    public List<Experiencia> getExperienciaList() {
        return experienciaRepository.findAll();
    }

    @Override
    public Experiencia findExperiencia(Long id) throws Exception {
        return experienciaRepository.findById(id).orElseThrow(() -> new Exception("No existe la experiencia"));
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);

    }

    @Override
    public Experiencia modifyExperiencia(Experiencia experiencia) throws Exception {
        Experiencia experienciaGuardar = findExperiencia(experiencia.getExpId());
        mapearExperiencia(experienciaGuardar, experiencia);
        return experienciaRepository.save(experienciaGuardar);
    }

    public void mapearExperiencia(Experiencia experienciaFij, Experiencia experienciaEdu) {
        experienciaFij.setTituloExp(experienciaEdu.getTituloExp());
        experienciaFij.setDescExp(experienciaEdu.getDescExp());
        experienciaFij.setImgExp(experienciaEdu.getImgExp());
        experienciaFij.setFechaExp(experienciaEdu.getFechaExp());
    }

}
