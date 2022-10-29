package com.portfoliobackend.controller;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliobackend.entity.Experiencia;
import com.portfoliobackend.service.IExperienciaService;

@CrossOrigin
@RestController
@RequestMapping("/experience")
public class ExperienciaController {

    @Autowired
    @Qualifier("ExperienciaServiceImp")
    private IExperienciaService experienciaSvc;

    private static final Log LOGGER = LogFactory.getLog(ExperienciaController.class);

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createExperience(@RequestBody Experiencia experiencia) {
        experienciaSvc.saveExperiencia(experiencia);
        LOGGER.debug("Experience created");
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/see/{id}")
    public ResponseEntity<Experiencia> getExperience(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(experienciaSvc.findExperiencia(id), HttpStatus.OK);
    }

    @GetMapping("/see/all")
    public ResponseEntity<List<Experiencia>> getExperienceList() {
        return new ResponseEntity<>(experienciaSvc.getExperienciaList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteExperience(@PathVariable Long id) {
        experienciaSvc.deleteExperiencia(id);
        LOGGER.info("Exper deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{idExp}")
    public ResponseEntity<Experiencia> editarEducacion(@PathVariable Long idExp, @RequestBody Experiencia experiencia)
            throws Exception {
        Experiencia experienciaUpd = experienciaSvc.modifyExperiencia(idExp, experiencia);
        LOGGER.info("Experience has edit successfully");
        return ResponseEntity.ok(experienciaUpd);
    }
}
