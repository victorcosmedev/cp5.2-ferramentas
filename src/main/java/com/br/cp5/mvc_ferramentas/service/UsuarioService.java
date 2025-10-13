package com.br.cp5.mvc_ferramentas.service;

import com.br.cp5.mvc_ferramentas.model.Usuario;
import com.br.cp5.mvc_ferramentas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario adicionarUsuario(Usuario user){
        System.out.println("Service");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
