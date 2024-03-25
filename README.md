# NeoStore

A aplicação NeoStore é um sistema de gerenciamento de fornecedores para uma loja fictícia, permitindo o cadastro, a edição, a exclusão e a listagem paginada de fornecedores.

## Funcionalidades

- Cadastro de fornecedores com validação de CNPJ e email.
- Edição e exclusão de fornecedores existentes.
- Listagem paginada de fornecedores.
- Importação de fornecedores via JSON.
- Validação de CNPJ e email para garantir unicidade no banco de dados.

## Tecnologias Utilizadas

- Java
- JAX-RS para construção da API REST
- Hibernate/JPA para persistência de dados
- Maven para gerenciamento de dependências e build
- Banco de dados MySQL

## Pré-requisitos

- Java JDK 11 ou superior
- Maven
- MySQL

## Configuração

### Banco de Dados

1. Crie um banco de dados no MySQL chamado `neostore`.
2. Configure as credenciais de acesso ao banco de dados no arquivo `src/main/resources/META-INF/persistence.xml`.

### Dependências

Instale as dependências do projeto executando:

```bash
mvn clean install
```

## Execução

Para iniciar a aplicação, execute:

```bash
mvn exec:java
```

A aplicação estará disponível em `http://localhost:8080/`.

## Endpoints da API

- **GET** `/supplier` - Lista todos os fornecedores (suporta paginação via query params `page` e `size`).
- **GET** `/supplier/{id}` - Busca um fornecedor pelo ID.
- **POST** `/supplier` - Cadastra um novo fornecedor. O corpo da requisição deve conter o nome, email, descrição e CNPJ do fornecedor.
- **PUT** `/supplier/{id}` - Atualiza os dados de um fornecedor existente.
- **DELETE** `/supplier/{id}` - Remove um fornecedor do sistema.
- **POST** `/supplier/import` - Importa uma lista de fornecedores via JSON.

## Testes

Execute os testes unitários com:

```bash
mvn test
```
