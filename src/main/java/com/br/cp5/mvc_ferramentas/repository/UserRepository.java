package com.br.cp5.mvc_ferramentas.repository;


import com.br.cp5.mvc_ferramentas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
