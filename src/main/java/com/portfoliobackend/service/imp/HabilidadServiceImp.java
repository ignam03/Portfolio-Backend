package com.portfoliobackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Habilidad;
import com.portfoliobackend.entity.Usuario;
import com.portfoliobackend.repository.HabilidadRepository;
import com.portfoliobackend.service.IHabiliadadService;

@Service("HabilidadServiceImp")
public class HabilidadServiceImp implements IHabiliadadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private UsuarioServiceImp usuarioSvc;

    @Override
    public void saveHabilidad(Habilidad habilidad, Long idUsuario) throws Exception {
        Usuario usr = usuarioSvc.findUsuario(idUsuario);
        habilidad.setUsuario2(usr);
        habilidadRepository.save(habilidad);
    }

    @Override
    public List<Habilidad> getHabilidadList() {
        return habilidadRepository.findAll();
    }

    @Override
    public Habilidad findHabilidad(Long id) throws Exception {
        return habilidadRepository.findById(id).orElseThrow(() -> new Exception("Habilidad not found"));
    }

    @Override
    public void deleteHabilidad(Long id) {
        habilidadRepository.deleteById(id);

    }

    @Override
    public Habilidad modifyHabilidad(Long idSkill, Habilidad habilidad) throws Exception {
        Habilidad habilidadGuardar = findHabilidad(idSkill);
        habilidadGuardar.setNombreHab(habilidad.getNombreHab());
        habilidadGuardar.setPorcentaje(habilidad.getPorcentaje());
        return habilidadRepository.save(habilidadGuardar);
    }

    public void mapearHabilidad(Habilidad habilidadFij, Habilidad habilidadUpd) {
        habilidadFij.setNombreHab(habilidadUpd.getNombreHab());
        habilidadFij.setPorcentaje(habilidadUpd.getPorcentaje());
    }

}
