package com.portfoliobackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Educacion;
import com.portfoliobackend.repository.EducacionRepository;
import com.portfoliobackend.service.IEducacionService;

@Service("EducacionServiceImp")
public class EducacionServiceImp implements IEducacionService {

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public void saveEducacion(Educacion eduacion) {
        educacionRepository.save(eduacion);

    }

    @Override
    public List<Educacion> getEducacionList() {

        return educacionRepository.findAll();
    }

    @Override
    public Educacion findEducacion(Long id) throws Exception {
        return educacionRepository.findById(id).orElseThrow(() -> new Exception("La experiencia no existe"));
    }

    @Override
    public void detectEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion modifyEducacion(Educacion educacion) throws Exception {
        Educacion educacionGuardar = findEducacion(educacion.getEduId());
        mapearEducacion(educacionGuardar, educacion);
        return educacionRepository.save(educacionGuardar);
    }

    public void mapearEducacion(Educacion educacionFij, Educacion educacionUpd) {
        educacionFij.setTitulo(educacionUpd.getTitulo());
        educacionFij.setNombreInstituacion(educacionUpd.getNombreInstituacion());
        educacionFij.setDescripcionEdu(educacionUpd.getDescripcionEdu());
        educacionFij.setFechaEdu(educacionUpd.getFechaEdu());

    }
}
