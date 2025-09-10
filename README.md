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

## 📂 Estrutura do Projeto

