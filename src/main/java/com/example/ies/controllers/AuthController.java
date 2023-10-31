package com.example.ies.controllers;
import com.example.ies.dao.UsuarioDao;
import com.example.ies.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario user) {
        if(usuarioDao.verificarCredenciales(user)) {
            return "OK";
        }
        return "FAIL";
    }
}
