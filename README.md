# 📦 Cadastro de Produtos API

API REST desenvolvida em **Spring Boot** para o cadastro e gerenciamento de produtos.  
Utiliza **MySQL 5.1** como banco de dados e **Spring Data JPA** para persistência.  

---

## 🚀 Tecnologias utilizadas
- ☕ **Java 8+**
- 🌱 **Spring Boot**
  - Spring Web
  - Spring Data JPA
- 🐬 **MySQL 5.1**
- 📝 **Lombok**

---

## 📌 Endpoints da API

### 🔹 Produtos
| Método | Endpoint                                      | Descrição                                     |
|--------|-----------------------------------------------|-----------------------------------------------|
| **POST**   | `http://127.0.0.1:8080/api/produto`            | Cadastra um novo produto                      |
| **GET**    | `http://127.0.0.1:8080/api/produto`            | Retorna todos os produtos cadastrados         |
| **GET**    | `http://127.0.0.1:8080/api/produto/{id}`       | Retorna um produto específico por **ID**      |
| **PUT**    | `http://127.0.0.1:8080/api/produto/{id}/atualizar` | Atualiza um produto existente                 |
| **DELETE** | `http://127.0.0.1:8080/api/produto/`           | Deleta **todos os produtos**                  |
| **DELETE** | `http://127.0.0.1:8080/api/produto/{id}`       | Deleta um produto específico por **ID**       |

---

caso queira utilizar docker, segue imagens

# Etapa 1 - Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2 - Imagem final para rodar a aplicação
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]

---

 Rodando com Docker

 Build e execução da API com Dockerfile

```bash
# Build da imagem
docker build -t cadastro-produtos-api .

# Rodar o container
docker run -p 8080:8080 --name produtos-api cadastro-produtos-api

