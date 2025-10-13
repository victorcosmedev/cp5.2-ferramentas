package com.br.cp5.mvc_ferramentas.service;

import com.br.cp5.mvc_ferramentas.exception.UserNotFoundException;
import com.br.cp5.mvc_ferramentas.model.Usuario;
import com.br.cp5.mvc_ferramentas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Usuario> getUser(Long id){
        return userRepository.findById(id);
    }

    public List<Usuario> getAllUsers(){
        return userRepository.findAll();
    }

    public Usuario atualizarUser(Long id, Usuario novoUsuario) throws UserNotFoundException {
        Usuario usuarioExistente = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setUsername(novoUsuario.getUsername());
        usuarioExistente.setPassword(passwordEncoder.encode(novoUsuario.getPassword()));

        return userRepository.save(usuarioExistente);
    }

    public boolean deletarUser(Long id){
        Optional<Usuario> usuarioExistente = userRepository.findById(id);
        if(usuarioExistente.isPresent()){
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }
}
