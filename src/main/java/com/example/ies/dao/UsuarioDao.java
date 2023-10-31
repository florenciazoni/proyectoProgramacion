package com.example.ies.dao;


import com.example.ies.models.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;
@Transactional
public interface UsuarioDao {

    List<Usuario> obtenerUsuarios();
    List<Usuario> getUsuarios();
    void eliminarUsuario(Long id);

    void registrarUsuario(Usuario user);

    boolean verificarCredenciales(Usuario user);
}
