[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/9ko37u_R)

# API de Gerenciamento de Produtos

Esta API permite a criação de produtos e a autenticação de usuários para gerenciar o catálogo de produtos. Abaixo estão algumas instruções para interagir com o sistema.

### Requisitos  
Node.js v14+ recomendado.  
Autenticação JWT: Necessário incluir o token JWT no cabeçalho das requisições protegidas.

### Utilização
Login: Envie uma requisição POST para http://localhost:8081/api/auth/login com o e-mail e a senha.
Salvar o token JWT: Use o token retornado para autenticar as próximas requisições.
Adicionar Produtos: Envie uma requisição POST para http://localhost:8081/api/produtos, incluindo o token JWT no cabeçalho e o corpo da requisição com os dados do produto.

> Com exceção das rotas <b>/login</b> e <b>/produtos (utilizando GET)</b>, as demais rotas necessitam de um token para serem acessadas.

## Endpoints

### 1. Autenticação - Fazer Login

#### Descrição:
Autentica o usuário para permitir o acesso aos demais endpoints protegidos da API.

- **Método:** `POST`
- **URL:** `http://localhost:8081/api/auth/login`

#### Exemplo de Payload (Corpo da Requisição):
(Dados definidos por padrão para autenticação)
```json
{
  "email": "william.silva@viannasempre.com.br",
  "password": "123456"
}  
```
***
### 2. Produtos - Listar todos os produtos

#### Descrição:
Traz uma lista com todos os produtos cadastrados.

- **Método:** `GET`
- **URL:** `http://localhost:8081/api/produtos`  

***
### 3. Produtos - Buscar produto pelo ID

#### Descrição:
Retorna apenas o produto com o ID buscado.

- **Método:** `GET`
- **URL:** `http://localhost:8081/api/produtos/ID-DO-PRODUTO`  

***
### 4. Produtos - Adicionar um produto

#### Descrição:
Adiciona um produto à lista.

- **Método:** `POST`
- **URL:** `http://localhost:8081/api/produtos`  

(Exemplo de corpo da requisição para adicionar um novo produto)
```json
{
  "nomeProduto": "AMD Radeon RX 7900 XTX",
  "precoUnitario": 8999.00,
  "quantidade": 15,
  "categoria": "Placas de Vídeo",
  "fabricanteNome": "AMD do Brasil",
  "fabricanteEndereco": {
    "logradouro": "Rua James Joule",
    "numero": "65",
    "bairro": "Cidade Monções",
    "cidade": "São Paulo",
    "cep": "04576-080",
    "uf": "SP"
  },
  "fabricanteTelefone": "01146898000"
}
```

***
### 5. Produtos - Alterar os dados de um produto

#### Descrição:
Altera as informações de um produto cadastrado.

- **Método:** `PUT`
- **URL:** `http://localhost:8081/api/produtos/ID-DO-PRODUTO`

***
### 5. Produtos - Deletar um produto

#### Descrição:
Deleta o registro de um produto cadastrado.

- **Método:** `DELETE`
- **URL:** `http://localhost:8081/api/produtos/ID-DO-PRODUTO`