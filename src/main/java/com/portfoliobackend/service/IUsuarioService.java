package com.portfoliobackend.service;

import java.util.List;

import com.portfoliobackend.entity.Usuario;

public interface IUsuarioService {

    public void saveUsuario(Usuario usuario);

    public List<Usuario> getUsuarios();

    public Usuario findUsuario(Long id) throws Exception;

    public void deleteUsuario(Long id);

    public Usuario modifyUsuario(Usuario usuario) throws Exception;
}
