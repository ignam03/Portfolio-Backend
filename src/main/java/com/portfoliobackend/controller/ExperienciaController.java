package com.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliobackend.entity.Experiencia;
import com.portfoliobackend.service.IExperienciaService;

@CrossOrigin
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    @Qualifier("ExperienciaServiceImp")
    private IExperienciaService experienciaSvc;

    @PostMapping("/nueva")
    public String agregarExperiencia(@RequestBody Experiencia experiencia) {
        experienciaSvc.saveExperiencia(experiencia);
        return "Se ha creado correctamente la experiencia";
    }

    @GetMapping("/ver/todas")
    public List<Experiencia> getExperienciaList() {
        List<Experiencia> listaExp = experienciaSvc.getExperienciaList();
        return listaExp;
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarExperiencia(@PathVariable Long id) {
        experienciaSvc.deleteExperiencia(id);
        return "Se ha eliminado correctamente la experiencia";
    }

    @GetMapping("/ver/{id}")
    public Experiencia getExperiencia(@PathVariable Long id) throws Exception {
        return experienciaSvc.findExperiencia(id);
    }

    @PostMapping("/editar/{id}")
    public Experiencia editarEducacion(@RequestBody Experiencia experiencia) throws Exception {
        Experiencia experienciaUpd = experienciaSvc.modifyExperiencia(experiencia);
        return experienciaUpd;
    }
}
