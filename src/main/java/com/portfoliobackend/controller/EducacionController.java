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

import com.portfoliobackend.entity.Educacion;
import com.portfoliobackend.service.IEducacionService;

@CrossOrigin
@RestController
@RequestMapping("/education")
public class EducacionController {

    @Autowired
    @Qualifier("EducacionServiceImp")
    private IEducacionService educacionSvc;

    private static final Log LOGGER = LogFactory.getLog(EducacionController.class);

    @PostMapping("/new/{idUsuario}")
    public ResponseEntity<HttpStatus> createEduaction(@RequestBody Educacion educacion, @PathVariable Long idUsuario)
            throws Exception {
        educacionSvc.saveEducacion(educacion, idUsuario);
        LOGGER.info("Education has Created");
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/see/{id}")
    public ResponseEntity<Educacion> getEducacion(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(educacionSvc.findEducacion(id), HttpStatus.OK);
    }

    @GetMapping("/see/all")
    public ResponseEntity<List<Educacion>> getEducacionList() {
        return new ResponseEntity<>(educacionSvc.getEducacionList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEducation(@PathVariable Long id) {
        educacionSvc.deleteEducacion(id);
        LOGGER.info("Education deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{idEdu}")
    public ResponseEntity<Educacion> editEducation(@PathVariable Long idEdu, @RequestBody Educacion educacion)
            throws Exception {
        Educacion educacionUpd = educacionSvc.modifyEducacion(idEdu, educacion);
        LOGGER.info("Educaction has edit successfully");
        return ResponseEntity.ok(educacionUpd);
    }
}
