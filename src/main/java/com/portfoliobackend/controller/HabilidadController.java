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

import com.portfoliobackend.entity.Habilidad;
import com.portfoliobackend.service.IHabiliadadService;

@CrossOrigin
@RestController
@RequestMapping("/skills")
public class HabilidadController {

    @Autowired
    @Qualifier("HabilidadServiceImp")
    private IHabiliadadService habilidadSvc;

    private static final Log LOGGER = LogFactory.getLog(HabilidadController.class);

    @PostMapping("/new/{idUsuario}")
    public ResponseEntity<HttpStatus> createSkill(@RequestBody Habilidad habilidad, @PathVariable Long idUsuario)
            throws Exception {
        habilidadSvc.saveHabilidad(habilidad, idUsuario);
        LOGGER.info("Skill created");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/see/{id}")
    public ResponseEntity<Habilidad> getSkill(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(habilidadSvc.findHabilidad(id), HttpStatus.OK);
    }

    @GetMapping("/see/all")
    public ResponseEntity<List<Habilidad>> getAllSkills() {
        return new ResponseEntity<>(habilidadSvc.getHabilidadList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSkill(@PathVariable Long id) {
        habilidadSvc.deleteHabilidad(id);
        LOGGER.info("Skill deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{idSkill}")
    public ResponseEntity<Habilidad> editSkill(@PathVariable Long idSkill, @RequestBody Habilidad skill)
            throws Exception {
        Habilidad toUpd = habilidadSvc.modifyHabilidad(idSkill, skill);
        LOGGER.info("Skill has edit successfully");
        return ResponseEntity.ok(toUpd);
    }

}
