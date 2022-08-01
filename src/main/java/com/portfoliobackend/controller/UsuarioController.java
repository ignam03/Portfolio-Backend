package com.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliobackend.entity.Usuario;
import com.portfoliobackend.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioServiceImp")
    private IUsuarioService usuarioSvc;

    @PostMapping("/new")
    public void agregarUsuario(@RequestBody Usuario usuario) {
        usuarioSvc.saveUsuario(usuario);
    }

    @GetMapping("/ver/usuarios")
    public List<Usuario> verUsuarios() {
        List<Usuario> usuarios = usuarioSvc.getUsuarios();
        return usuarios;
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarUsuario(@PathVariable Long id) {
        usuarioSvc.deleteUsuario(id);
    }

    @GetMapping("/ver/{id}")
    public Usuario getUsuario(@PathVariable Long id) throws Exception {
        return usuarioSvc.findUsuario(id);
    }

    @PostMapping("/editar/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario) throws Exception {
        Usuario usuarioUpd = usuarioSvc.modifyUsuario(usuario);
        return usuarioUpd;
    }
}
