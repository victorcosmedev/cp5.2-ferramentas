package com.br.cp5.mvc_ferramentas.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long id){ super("Usuário de ID " + id + " não foi encontrado."); }
}
