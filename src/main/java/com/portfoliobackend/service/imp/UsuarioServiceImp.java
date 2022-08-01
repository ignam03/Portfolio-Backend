package com.portfoliobackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliobackend.entity.Usuario;
import com.portfoliobackend.repository.UsuarioRepository;
import com.portfoliobackend.service.IUsuarioService;

@Service("UsuarioServiceImp")
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioDaoImp;

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioDaoImp.save(usuario);

    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDaoImp.findAll();
    }

    @Override
    public Usuario findUsuario(Long id) throws Exception {
        return usuarioDaoImp.findById(id).orElseThrow(() -> new Exception("El usuario no existe"));
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioDaoImp.deleteById(id);
    }

    @Override
    public Usuario modifyUsuario(Usuario usuario) throws Exception {
        Usuario usuarioGuardar = findUsuario(usuario.getUserId());
        mapearUsuario(usuarioGuardar, usuario);
        return usuarioDaoImp.save(usuarioGuardar);
    }

    public void mapearUsuario(Usuario usuarioFij, Usuario usuarioUpd) {
        usuarioFij.setNombre(usuarioUpd.getNombre());
        usuarioFij.setApellido(usuarioUpd.getApellido());
        usuarioFij.setDescripcion(usuarioUpd.getDescripcion());
        usuarioFij.setTitulo(usuarioUpd.getDescripcion());
        usuarioFij.setFotoPerfil(usuarioUpd.getFotoPerfil());
    }
}
