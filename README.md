# NeoStore

A aplicação NeoStore é um sistema de gerenciamento de fornecedores para uma loja fictícia, permitindo o cadastro, a edição, a exclusão, e a listagem paginada de fornecedores.

## Funcionalidades

- Cadastro de fornecedores com validação de CNPJ e email.
- Edição e exclusão de fornecedores existentes.
- Listagem paginada de fornecedores.
- Importação de fornecedores via JSON.
- Validação de CNPJ e email para garantir unicidade no banco de dados.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para desenvolvimento da aplicação.
- **JAX-RS (Jersey 2.30.1)**: Para construção da API REST, facilitando a comunicação entre o cliente e o servidor.
- **Hibernate/JPA (Hibernate 5.4.12.Final)**: Para persistência de dados, mapeamento objeto-relacional e implementação da especificação JPA para acesso ao banco de dados.
- **Maven**: Para gerenciamento de dependências e automação de build.
- **MySQL (MySQL Connector/J 8.0.19)**: Como sistema de gerenciamento de banco de dados.
- **JUnit (JUnit 4.13.2 e JUnit Jupiter 5.7.0)**: Para testes unitários e de integração.
- **Jackson (Jackson Databind 2.17.0)**: Para serialização e deserialização de objetos Java para JSON e vice-versa.
- **Hibernate Validator (Hibernate Validator 7.0.1.Final)**: Para validação de dados de entrada com base nas anotações de validação do Bean Validation.
- **Lombok (1.18.30)**: Para redução de código boilerplate com anotações que geram código em tempo de compilação, como getters, setters, e constructors.
- **Jakarta Persistence (Jakarta Persistence-api 2.2.3)** e **Jakarta Validation (Jakarta Validation-api 2.0.2)**: Para padronização e validação de persistência de dados.

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
- **GET** `/supplier/cnpj/{cnpj}` - Busca um fornecedor pelo CNPJ.
- **GET** `/supplier/email/{email}` - Busca um fornecedor pelo Email.
- **POST** `/supplier` - Cadastra um novo fornecedor. O corpo da requisição deve conter o nome, email, descrição e CNPJ do fornecedor.
- **PUT** `/supplier/{id}` - Atualiza os dados de um fornecedor existente.
- **DELETE** `/supplier/{id}` - Remove um fornecedor do sistema.
- **POST** `/supplier/import` - Importa uma lista de fornecedores via JSON.

## Testes

Execute os testes unitários com:

```bash
mvn test
```
