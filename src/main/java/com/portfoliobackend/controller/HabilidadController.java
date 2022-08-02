package com.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliobackend.entity.Habilidad;
import com.portfoliobackend.service.IHabiliadadService;

@RestController
@RequestMapping("/skills")
public class HabilidadController {

    @Autowired
    @Qualifier("HabilidadServiceImp")
    private IHabiliadadService habilidadSvc;

    @PostMapping("/nueva")
    public String agregarSkill(@RequestBody Habilidad habilidad) {
        habilidadSvc.saveHabilidad(habilidad);
        return "Se ha creado correctamente la skill";
    }

    @GetMapping("/ver/todas")
    public List<Habilidad> getSkillList() {
        List<Habilidad> listaSkills = habilidadSvc.getHabilidadList();
        return listaSkills;
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarSkill(@PathVariable Long id) {
        habilidadSvc.deleteHabilidad(id);
        return "Se ha eliminado correctamente la skill";
    }

    @GetMapping("/ver/{id}")
    public Habilidad getSkills(@PathVariable Long id) throws Exception {
        return habilidadSvc.findHabilidad(id);
    }

}
