package com.br.cp5.mvc_ferramentas.controller;

import com.br.cp5.mvc_ferramentas.exception.UserNotFoundException;
import com.br.cp5.mvc_ferramentas.model.Usuario;
import com.br.cp5.mvc_ferramentas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/register")
    public String adicionarUsuarioForm(Model model) {
        model.addAttribute("user", new Usuario());
        return "register";
    }

    @PostMapping
    public String adicionarUsuario(Usuario user) {
        userService.adicionarUsuario(user);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String carregarFormularioEdicao(@PathVariable Long id, Model model) throws UserNotFoundException {
        Usuario user = userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        model.addAttribute("user", user);
        return "formulario-atualiza-usuario";
    }

    @PutMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Usuario user) throws UserNotFoundException {
        userService.atualizarUser(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String deletarPorId(@PathVariable Long id) {
        userService.deletarUser(id);
        return "redirect:/user";
    }
}
