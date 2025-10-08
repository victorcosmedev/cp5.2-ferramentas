package com.br.cp5.mvc_ferramentas.service;

import com.br.cp5.mvc_ferramentas.exception.UserNotFoundException;
import com.br.cp5.mvc_ferramentas.model.User;
import com.br.cp5.mvc_ferramentas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User adicionarUsuario(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User atualizarUser(Long id, User novoUsuario) throws UserNotFoundException {
        User usuarioExistente = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setUsername(novoUsuario.getUsername());
        usuarioExistente.setPassword(novoUsuario.getPassword());

        return userRepository.save(usuarioExistente);
    }

    public boolean deletarUser(Long id){
        Optional<User> usuarioExistente = userRepository.findById(id);
        if(usuarioExistente.isPresent()){
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
