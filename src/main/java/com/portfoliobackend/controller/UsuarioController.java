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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.portfoliobackend.entity.Usuario;
import com.portfoliobackend.service.IUsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/portfolio")
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioServiceImp")
    private IUsuarioService usuarioSvc;

    private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);

    @PostMapping("/new")
    public ResponseEntity<HttpStatusCodeException> createUser(@RequestBody Usuario usuario) {
        usuarioSvc.saveUsuario(usuario);
        LOGGER.info("User created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/see/user/{userId}")
    public ResponseEntity<Usuario> getUser(@PathVariable Long userId) throws Exception {
        return new ResponseEntity<>(usuarioSvc.findUsuario(userId), HttpStatus.OK);
    }

    @GetMapping("/see/all")
    public ResponseEntity<List<Usuario>> getAllUser() {
        return new ResponseEntity<>(usuarioSvc.getUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        usuarioSvc.deleteUsuario(id);
        LOGGER.info("User deleted successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario) throws Exception {
        Usuario usuarioUpd = usuarioSvc.modifyUsuario(usuario);
        return usuarioUpd;
    }
}
