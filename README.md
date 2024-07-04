# Literalura

## Descrição
O projeto Literatura é uma aplicação Java que integra dados de livros e autores utilizando a API Gutendex e armazenamento em um banco de dados PostgreSQL. Ele oferece funcionalidades para listar livros por título, idioma, autores vivos em um ano específico, estatísticas como contagem de livros por idioma, e exibe os top 10 livros mais baixados.

## Funcionalidades

- Listagem de livros por título, idioma e autores vivos em um ano específico.
- Busca dos top 10 livros mais baixados.
- Integração com API Gutendex para busca dinâmica de livros.
- Armazenamento e consulta de dados em banco de dados PostgreSQL.
- Estatísticas de contagem de livros por idioma.

## Estrutura do Projeto

O projeto está estruturado nos seguintes pacotes principais:

- `com.alura.literatura.controller`: Controladores para manipulação de requisições HTTP.
- `com.alura.literatura.model`: Modelos de dados, incluindo classes como `Livro` e `Autor`.
- `com.alura.literatura.repository`: Repositórios JPA para acesso a dados.
- `com.alura.literatura.service`: Serviços que encapsulam a lógica de negócio.
- `com.alura.literatura.principal`: Classe principal `Principal` para execução da aplicação.

## Uso

Para executar a aplicação:

1. Configure as credenciais do banco de dados PostgreSQL em `application.properties`.
2. Execute a aplicação utilizando Spring Boot:
3. Use o menu interativo para explorar as funcionalidades disponíveis.
![Captura de tela 2024-07-04 204026](https://github.com/Kaio-0708/Liter_Alura/assets/123708201/7cff41cf-5cf8-4e71-bf84-8f55b3ca647a)


## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)
