# --- Estágio 1: Build (Compilação) ---
# Usa uma imagem Docker que já vem com Maven e JDK 17 para compilar o projeto.
FROM eclipse-temurin:17-jdk-jammy as builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o pom.xml primeiro para aproveitar o cache do Docker
COPY pom.xml .

# Copia o resto do código-fonte do projeto
COPY src ./src

# Executa o comando do Maven para baixar as dependências e empacotar a aplicação em um arquivo .jar
# -DskipTests pula a execução dos testes para acelerar o build no deploy
RUN mvn clean package -DskipTests


# --- Estágio 2: Run (Execução) ---
# Usa uma imagem Docker muito menor, apenas com o ambiente de execução Java (JRE), para rodar a aplicação.
FROM eclipse-temurin:17-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar que foi gerado no estágio "builder" para a imagem final
COPY --from=builder /app/target/mvc-ferramentas-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080, que é a porta padrão do Spring Boot
EXPOSE 8080

# Define o comando que será executado quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]