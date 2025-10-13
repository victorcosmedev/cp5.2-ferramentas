# Projeto MVC - Loja de Ferramentas

## 📖 Sobre o Projeto

Este repositório contém o código-fonte de uma aplicação web MVC desenvolvida em Java com o framework Spring Boot. O projeto simula o sistema de gerenciamento para uma "Loja de Ferramentas", implementando funcionalidades essenciais como cadastro de produtos, controle de acesso de usuários e autenticação segura.

Este projeto foi desenvolvido como uma atividade acadêmica, demonstrando a aplicação prática dos conceitos de desenvolvimento back-end e segurança de aplicações.

## ✨ Funcionalidades Principais

  * **🔐 Autenticação e Segurança**

      * Sistema completo de registro, login e logout de usuários utilizando **Spring Security**.
      * Senhas armazenadas de forma segura no banco de dados com criptografia **BCrypt**.
      * Controle de acesso baseado em autenticação: apenas usuários logados podem gerenciar os produtos.

  * **⚙️ Gerenciamento de Produtos (CRUD)**

      * **Listagem:** Visualização de todos os produtos cadastrados em uma interface clara.
      * **Criação:** Formulário para adicionar novos produtos ao catálogo.
      * **Atualização:** Formulário para editar as informações de um produto existente.
      * **Deleção:** Opção para remover um produto do sistema de forma segura.

  * **🔍 Busca Dinâmica**

      * Funcionalidade de busca para filtrar produtos pelo nome, facilitando a navegação.

## 🛠️ Tecnologias Utilizadas

A aplicação foi construída utilizando um conjunto de tecnologias modernas e robustas do ecossistema Java/Spring:

  * **Backend:**

      * **Java 17**
      * **Spring Boot 3.5.6**
      * **Spring Web (MVC):** Para a construção de aplicações web seguindo o padrão Model-View-Controller.
      * **Spring Security:** Para gerenciamento de autenticação e autorização.
      * **Spring Data JPA / Hibernate:** Para persistência de dados e mapeamento objeto-relacional.

  * **Frontend:**

      * **Thymeleaf:** Motor de templates para renderizar as páginas web no lado do servidor.
      * HTML5 & CSS3

  * **Banco de Dados:**

      * **Oracle Database:** Conectado via driver JDBC (`ojdbc11`).

  * **Ferramentas e Dependências:**

      * **Apache Maven:** Para gerenciamento de dependências e build do projeto.
      * **Project Lombok:** Para reduzir o código boilerplate (getters, setters, construtores).
      * **Spring Boot DevTools:** Para facilitar o desenvolvimento com live reload.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar a aplicação em seu ambiente local.

### Pré-requisitos

  * **JDK 17** ou superior.
  * **Apache Maven 3.8** ou superior.
  * Uma instância do **Oracle Database** acessível.
  * Uma IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code).

### 1\. Clonar o Repositório

```bash
git clone https://github.com/victorcosmedev/cp5.2-ferramentas.git
cd mvc-ferramentas
```

### 2\. Configurar o Banco de Dados

Antes de executar, é crucial configurar as credenciais de acesso ao seu banco de dados Oracle.

1.  Navegue até o arquivo `src/main/resources/application.properties` (ou `application.yml`).

2.  Altere as seguintes propriedades com as suas informações:

    ```properties
    server:
      port: 8080
      error:
        include-message: always
        include-binding-errors: always
    
    spring:
      datasource:
        url: jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
        username: SEU LOGIN
        password: SUA SENHA
        driver-class-name: oracle.jdbc.OracleDriver
      mvc:
        hiddenmethod:
          filter:
            enabled: true
      jpa:
        hibernate:
          ddl-auto: update
        properties:
          hibernate:
            dialect: org.hibernate.dialect.OracleDialect
            format_sql: true
        show-sql: true
    ```

### 3\. Executar a Aplicação

1.  Abra o projeto na sua IDE.
2.  Localize a classe principal `MvcFerramentasApplication.java`.
3.  Execute o método `main` para iniciar o servidor Spring Boot.
4.  A aplicação estará disponível para acesso no seu navegador em `http://localhost:8080`.

## 👨‍💻 Autores

Este projeto foi desenvolvido por:

  * **Arthur Eduardo Luna Pulini** - `RM 554848`
  * **Lucas Almeida Fernandes de Moraes** - `RM 557569`
  * **Victor Nascimento Cosme** - `RM 558856`
