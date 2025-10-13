package com.br.cp5.mvc_ferramentas.controller;

import com.br.cp5.mvc_ferramentas.model.Usuario;
import com.br.cp5.mvc_ferramentas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/register")
    public String adicionarUsuarioForm(Model model) {
        model.addAttribute("user", new Usuario());
        return "register";
    }

    @PostMapping
    public String adicionarUsuario(Usuario user) {
        System.out.println("CONTROLLER");
        usuarioService.adicionarUsuario(user);
        return "redirect:/";
    }

}
