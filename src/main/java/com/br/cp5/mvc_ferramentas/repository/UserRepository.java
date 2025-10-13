package com.br.cp5.mvc_ferramentas.repository;


import com.br.cp5.mvc_ferramentas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
