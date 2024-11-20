
# Atividade 16 - API REST com Spring Boot

Este projeto faz parte das atividades propostas pela **Codifica** e tem como objetivo desenvolver uma API RESTful utilizando **Spring Boot**, com funcionalidades completas de **CRUD (Create, Read, Update, Delete)** e documentação interativa via **Swagger**.

---

## 📋 Descrição do Projeto

A atividade consiste na criação de uma API para gerenciar uma lista de produtos, permitindo a realização de operações básicas como adicionar, consultar, atualizar e excluir produtos. A API foi projetada com base em boas práticas de arquitetura em camadas e conta com uma documentação interativa via Swagger para facilitar sua exploração e uso.

---

## 📦 Funcionalidades da API

### Gerenciamento de Produtos
- **Adicionar Produto (Create):** Insere um novo produto no sistema.
- **Listar Produtos (Read):** Retorna todos os produtos cadastrados ou busca por ID.
- **Atualizar Produto (Update):** Atualiza os dados de um produto existente.
- **Remover Produto (Delete):** Exclui um produto do sistema.

### Estrutura dos Produtos
Cada produto possui os seguintes atributos:
- **ID:** Identificador único.
- **Nome:** Nome do produto.
- **Descrição:** Informações sobre o produto.
- **Preço:** Valor do produto.
- **Quantidade em Estoque:** Quantidade disponível.

---

## 🚀 Tecnologias Utilizadas

- **Framework:** Spring Boot 3.x
- **Banco de Dados:** H2 Database (em memória)
- **Documentação:** Swagger (Springdoc OpenAPI 3)
- **Linguagem:** Java 17+
- **Dependências:**
  - Spring Data JPA
  - Spring Web
  - H2 Database
  - Springdoc OpenAPI UI

---

## 📁 Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── maisprati/
│   │   │   │   ├── tarefa16/
│   │   │   │   │   ├── entities/
│   │   │   │   │   │   ├── Produto.java           # Entidade Produto
│   │   │   │   │   ├── repositories/
│   │   │   │   │   │   ├── ProdutoRepository.java # Repositório Produto
│   │   │   │   │   ├── services/
│   │   │   │   │   │   ├── ProdutoService.java    # Lógica de negócios para Produtos
│   │   │   │   │   ├── controllers/
│   │   │   │   │   │   ├── ProdutoController.java # Endpoints relacionados a Produtos
│   └── resources/
│       ├── application.properties  # Configurações da aplicação
```

---

## 🌐 Documentação da API com Swagger

A API utiliza **Swagger** para oferecer uma interface interativa onde é possível visualizar, testar e explorar os endpoints.

### Acesso à Documentação
- Após iniciar a aplicação, acesse o Swagger UI no seguinte endereço:
  ```
  http://localhost:8080/swagger-ui.html
  ```
- Todos os endpoints disponíveis estarão detalhados, com informações sobre:
  - Métodos HTTP utilizados.
  - Estrutura das requisições.
  - Exemplos de respostas.

---

## 🔧 Como Executar o Projeto

### Pré-requisitos
- **Java 17** ou superior instalado.
- Maven configurado na máquina.

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/fernando-angeli/maisPraTi_tarefa16.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd maisPraTi_tarefa16
   ```
3. Configure as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a aplicação em `http://localhost:8080`.

---

## 🛠️ Endpoints da API

### Produtos
- **POST /api/produtos**
  - Cria um novo produto.
  - **Body da requisição:**
    ```json
    {
      "nome": "Nome do Produto",
      "descricao": "Descrição do Produto",
      "preco": 100.50,
      "quantidadeEmEstoque": 10
    }
    ```

- **GET /api/produtos**
  - Retorna todos os produtos cadastrados.

- **GET /api/produtos/{id}**
  - Retorna um produto específico pelo ID.

- **PUT /api/produtos/{id}**
  - Atualiza as informações de um produto.
  - **Body da requisição:**
    ```json
    {
      "nome": "Novo Nome do Produto",
      "descricao": "Nova Descrição",
      "preco": 120.00,
      "quantidadeEmEstoque": 15
    }
    ```

- **DELETE /api/produtos/{id}**
  - Remove um produto do sistema.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Caso deseje colaborar, sinta-se à vontade para abrir uma **issue** ou enviar um **pull request**.

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

--- 

Feito com 💻 por Fernando Angeli e Codifica Edu.
