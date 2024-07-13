# API Spring com MongoDB

### Feito com

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
- ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
- ![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
- ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
- ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

> ### Projeto Back-end
> Projeto foi parte do curso de back-end com Java e Spring
> - Prof. Dr. Nelio Alves
> - [http://educandoweb.com.br](https://devsuperior.com.br/)


## Objetivos estudados com o projeto:

- Compreender as principais diferenças entre paradigma orientado a documentos e relacional
- Implementar operações de CRUD
- Refletir sobre decisões de design para um banco de dados orientado a documentos
- Implementar associações entre objetos
  - Objetos aninhados
  - Referências
- Realizar consultas com Spring Data e MongoRepository

## Camadas Lógicas

![Screenshot 2024-07-12 204032](https://github.com/user-attachments/assets/f1a40d6b-fdbf-41a4-be68-464811cc7fa8)

## Instância de Domínio

![Screenshot 2024-07-12 204338](https://github.com/user-attachments/assets/d281fc8e-4f68-44a9-8382-10231c6f3160)

## Modelo de Domínio

![Screenshot 2024-07-12 204548](https://github.com/user-attachments/assets/2fd0b8b6-cafe-438a-9762-9de6dcad0186)

> [!IMPORTANT]
> A seguir terá a explicação de como se chegou neste modelo de domínio.

  Se neste projeto fosse utilizado um banco de dados relacional o modelo de domínio ficaria como a imagem a seguir:

![Screenshot 2024-07-12 205349](https://github.com/user-attachments/assets/609e674e-1152-4d66-92a0-5965ecce60fb)

  E para fazer consulta, considerando que houvesse muitos dados, a recuperação dos dados aconteceria conforme o exemplo a seguir:

![Screenshot 2024-07-12 205631](https://github.com/user-attachments/assets/7020bc44-5f99-4a52-ae0e-373f9bd88d40)

  Assim na implementação dos objetos, as associações entre objetos, seriam feitas por referências dos ponteiros, e para se fazer as consultas, considerando uma base de dados grande, as consultas iriam requer muito recurso, tornando as consultas lentas.

  Logo foi decidido por implementar, conforme a primeira imagem, onde as consultas, considerando uma base de dados grande, iriam requerir menos recursos, mesmo que pra isso seja necessário haver a desnomalização dos dados.

> [!TIP]
> A seguir, a forma que foi implementado.

  Da forma que foi implementado, optando por escolhe um banco de dados não relacional, as consultas realizadas trazem os dados conforme o exemplo a seguir:

```json

{
  "id": "1001",
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "posts": ["5001", "5010"]
}

{
  "id": "5001",
  "date": "2018-03-21",
  "title": "Partiu viagem",
  "body": "Vou viajar para São Paulo. Abraços!",
  "author": {
    "id": "1001",
    "name": "Maria Brown"
  },
  "comments": [
    {
      "text": "Boa viagem mano!",
      "date": "2018-03-21",
      "author": {
        "id": "1013",
        "name": "Alex Green"
      }
    },
    {
      "text": "Aproveite!",
      "date": "2018-03-22",
      "author": {
        "id": "1027",
        "name": "Bob Grey"
      }
    }
  ]
}

{
  "id": "5010",
  "date": "2018-03-23",
  "title": "Bom dia",
  "body": "Acordei feliz hoje!",
  "author": {
    "id": "1001",
    "name": "Maria Brown"
  },
  "comments": [
    {
      "text": "Tenha um ótimo dia!",
      "date": "2018-03-23",
      "author": {
        "id": "1013",
        "name": "Alex Green"
      }
    }
  ]
}

```
#
> Projeto foi parte do curso de back-end com Java e Spring
> - Prof. Dr. Nelio Alves
> - [http://educandoweb.com.br](https://devsuperior.com.br/)

### Referências:
- https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-nosql.html
- https://stackoverflow.com/questions/38921414/mongodb-what-are-the-default-user-and-password
- https://pt.stackoverflow.com/questions/31362/o-que-é-um-dto
