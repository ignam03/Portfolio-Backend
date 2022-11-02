package com.portfoliobackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Experiencia;
import com.portfoliobackend.entity.Usuario;
import com.portfoliobackend.repository.ExperienciaRepository;
import com.portfoliobackend.service.IExperienciaService;

@Service("ExperienciaServiceImp")
public class ExperienciaServiceImp implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private UsuarioServiceImp usuarioSvc;

    @Override
    public void saveExperiencia(Experiencia experiencia, Long idUsuario) throws Exception {
        Usuario usr = usuarioSvc.findUsuario(idUsuario);
        experiencia.setUsuario1(usr);
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
    public Experiencia modifyExperiencia(Long idExp, Experiencia experiencia) throws Exception {
        Experiencia experienciaGuardar = findExperiencia(idExp);
        experienciaGuardar.setTituloExp(experiencia.getTituloExp());
        experienciaGuardar.setDescExp(experiencia.getDescExp());
        experienciaGuardar.setImgExp(experiencia.getImgExp());
        experienciaGuardar.setFechaExp(experiencia.getFechaExp());
        return experienciaRepository.save(experienciaGuardar);
    }

    public void mapearExperiencia(Experiencia experienciaFij, Experiencia experienciaEdu) {
        experienciaFij.setTituloExp(experienciaEdu.getTituloExp());
        experienciaFij.setDescExp(experienciaEdu.getDescExp());
        experienciaFij.setImgExp(experienciaEdu.getImgExp());
        experienciaFij.setFechaExp(experienciaEdu.getFechaExp());
    }

}
