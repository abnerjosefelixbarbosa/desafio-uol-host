# challenge-uol-host

## About

UOL host technical challenge.

## Project resource

### Backend java

- Java 17
- Spring boot.
- Clean arch.
- SOLID.
- Swegger.
- H2SQL.
- JUnit 5.

### Function

- Register player.
- List players.
- Delete player by id.
- Update player.

## End points

### Register player

```JSON
POST
/api/players/register-player

{
  "name": "string",
  "email": "string",
  "phone": "string",
  "type": "AVENGERS"
}
```

### List player

```JSON
GET
/api/players/list-players
```

### Delete player by id

```JSON
DELETE
/api/players/delete-player-by-id?id=
```

### Update player

```JSON
PUT
/api/players/update-player?id=

{
  "name": "string",
  "email": "string",
  "phone": "string",
  "type": "AVENGERS"
}
```

# Project execution

- Copy the repository.
- Import the project in a Java IDE.
- Excute the project.
- Access [API document](http://localhost:8080/swagger-ui/index.html) or use a platform for API testing.

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Author

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
