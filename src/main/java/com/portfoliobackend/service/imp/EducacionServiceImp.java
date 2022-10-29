package com.portfoliobackend.service.imp;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Educacion;
import com.portfoliobackend.repository.EducacionRepository;
import com.portfoliobackend.service.IEducacionService;

@Service("EducacionServiceImp")
public class EducacionServiceImp implements IEducacionService {

    @Autowired
    private EducacionRepository educacionRepository;

    private static final Log LOGGER = LogFactory.getLog(EducacionServiceImp.class);

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
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion modifyEducacion(Long idEdu, Educacion educacion) throws Exception {
        Educacion eToUpd = findEducacion(idEdu);
        eToUpd.setTitulo(educacion.getTitulo());
        eToUpd.setNombreInstituacion(educacion.getNombreInstituacion());
        eToUpd.setDescripcionEdu(educacion.getDescripcionEdu());
        eToUpd.setFechaEdu(educacion.getFechaEdu());
        eToUpd.setImagEdu(educacion.getImagEdu());
        return educacionRepository.save(eToUpd);
    }

    public void mapearEducacion(Educacion educacionFij, Educacion educacionUpd) {
        educacionFij.setTitulo(educacionUpd.getTitulo());
        educacionFij.setNombreInstituacion(educacionUpd.getNombreInstituacion());
        educacionFij.setDescripcionEdu(educacionUpd.getDescripcionEdu());
        educacionFij.setFechaEdu(educacionUpd.getFechaEdu());
        educacionFij.setImagEdu(educacionUpd.getImagEdu());

    }
}
