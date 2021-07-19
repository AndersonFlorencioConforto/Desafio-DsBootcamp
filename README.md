<h1 align="center">
    Desafio-DsBootcamp
</h1>


<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;&&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>


<br>



## 🚀 Tecnologias

Esses códigos foram desenvolvidos com as seguintes tecnologias:

- [Java™ Platform, Standard Edition 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)

- [Spring Boot](https://spring.io/projects/spring-boot)

- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)   

- [H2 - Console ](https://www.h2database.com/html/main.html)

- [Maven](https://maven.apache.org/guides/index.html)

- [Postman](https://learning.postman.com/docs/getting-started/introduction/)

- [Eclipse](https://www.eclipse.org/)




  <br>


## 💻 Projeto

⚡️ Enunciado
Você deverá entregar um projeto Spring Boot 2.4.x contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:
Busca paginada de recursos
Busca de recurso por id
Inserir novo recurso
Atualizar recurso
Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, e Java 11 como linguagem.

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos.


## Busca paginada de clientes
```
GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name
```


## Busca de cliente por id
```
GET /clients/1
```

## Inserção de novo cliente
```
POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

## Atualização de cliente

```
PUT /clients/1
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

## Deleção de cliente
```
DELETE /clients/1
```


 
 


### 📫 Dúvidas ou sugestões segue o Linkedin! [LinkedIn](https://www.linkedin.com/in/anderson-florencio-conforto-b77577202/)

