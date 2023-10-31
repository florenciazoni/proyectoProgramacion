package com.example.ies.controllers;

import com.example.ies.dao.UsuarioDao;
import com.example.ies.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {



    @Autowired
    private UsuarioDao usuarioDao;

   @RequestMapping(value="mensaje")
    public  String saludo(){

        return "hola mundooooooo";

    }


    @RequestMapping(value="listar")
    public List<String> listarPersonas(){

     return List.of("Florencia", "Zoni","Candy");

    }


    @RequestMapping(value="api/usuarios")
    public List<Usuario> getUsuarios() {

        List<Usuario> user = usuarioDao.getUsuarios();
        return user;
    }

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario user) {
        Argon2 argon2;
       argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String pass_hasheado = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(pass_hasheado);
        usuarioDao.registrarUsuario(user);

    }



}
