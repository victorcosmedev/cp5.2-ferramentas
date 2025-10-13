# --- Estágio 1: Build (Compilação) ---
# CORREÇÃO AQUI: Usamos uma imagem oficial do Maven que já inclui o JDK 17.
# Esta imagem tem tudo o que é necessário para compilar seu projeto.
FROM maven:3.9.6-eclipse-temurin-17-jammy as builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o pom.xml primeiro para aproveitar o cache do Docker
COPY pom.xml .

# Copia o resto do código-fonte do projeto
COPY src ./src

# Executa o comando do Maven. Agora o comando 'mvn' será encontrado.
RUN mvn clean package -DskipTests


# --- Estágio 2: Run (Execução) ---
# Esta parte continua igual, usando a imagem leve apenas com o JRE.
FROM eclipse-temurin:17-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar que foi gerado no estágio "builder" para a imagem final
COPY --from=builder /app/target/mvc-ferramentas-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Define o comando que será executado quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]