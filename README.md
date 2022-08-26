# Seja bem vindo ao projeto Aluraflix 🔥

## O projeto 📄

Aluraflix é um projeto fictício de backend disponível na plataforma [alura](https://alura.com.br/). 

O projeto consiste na criação de uma **API** plataforma simples de vídeos ( CRUD ) onde o usuário irá poder:

- Cadastrar novos vídeos
- Listar novos vídeos
- Fazer buscas por vídeos ou por sua categoria
- Remove vídeos

## Tecnologias 🧑🏽‍💻

- [Java v11](https://www.java.com/pt-BR/download/)
- [Spring](https://spring.io/)
- [H2 Database](http://www.h2database.com/html/quickstart.html)
- [Docker](https://www.docker.com/get-started/)
- [Docker Compose](https://docs.docker.com/compose/)
- [JUnit](https://junit.org/junit5/)
- [PostgreSQL](https://www.postgresql.org/)
- [PgAdmin](https://www.pgadmin.org/)
- [Swagger](https://swagger.io/)
- [Maven](https://maven.apache.org/)

## Levantando o banco de dados utilizando docker-compose 🐳

Primeiramente você precisa ter o **docker e o docker compose** instalados em sua máquina para utilizar o banco de dados.

Caso você não possua, siga está **[documentação](https://docs.docker.com/)** para realizar a instalação de ambos. 

## Como utilizar 🤔

Primeiramente clone este repositório.

```
git clone https://github.com/ruanvalente/aluraflix

```
Entre na pasta `backend` e utilize o maven para instalar as dependências do projeto.

Agora para levantar o banco basta utilizar o docker-compose
```
docker-compose up -d
```

Agora basta executar o projeto acessando: `http://localhost:8080/swagger-ui.html` assim você poderá acessar o `swagger` que irá informar todos os `endpoints` disponíveis dentro da aplicação 🚀

<img width="1440" alt="Captura de Tela 2022-08-18 às 19 40 02" src="https://user-images.githubusercontent.com/6674232/185507530-ebe645b0-26c5-49a2-bbb3-e2423a078572.png">
