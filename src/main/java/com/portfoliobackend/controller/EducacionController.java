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

import com.portfoliobackend.entity.Educacion;
import com.portfoliobackend.service.IEducacionService;

@CrossOrigin
@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    @Qualifier("EducacionServiceImp")
    private IEducacionService educacionSvc;

    @PostMapping("/nuevo")
    public String agregarEducacion(@RequestBody Educacion educacion) {
        educacionSvc.saveEducacion(educacion);
        return "Se ha creado correctamente el usuario";
    }

    @GetMapping("/ver/todas")
    public List<Educacion> getEducacionList() {
        List<Educacion> listaEdu = educacionSvc.getEducacionList();
        return listaEdu;
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarEducacion(@PathVariable Long id) {
        educacionSvc.deleteEducacion(id);
        return "Se ha eliminado correctamente la educacion";
    }

    @GetMapping("/ver/{id}")
    public Educacion getEducacion(@PathVariable Long id) throws Exception {
        return educacionSvc.findEducacion(id);
    }

    @PostMapping("/editar/{id}")
    public Educacion editarEducacion(@RequestBody Educacion educacion) throws Exception {
        Educacion educacionUpd = educacionSvc.modifyEducacion(educacion);
        return educacionUpd;
    }
}
