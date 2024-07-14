# Challenge uol host

## About

Challenge technical UOL host.

## Model

![host_UOL_class_diagram](https://github.com/user-attachments/assets/ff55984e-9ad8-4ed0-82ac-e261ed2b7f90)

# Project resource

## Frontend angular

- Angular.
- TypeScript.
- Matirial angular.
- Ngx mask.

## Backend java

- Java 17.
- Spring boot.
- Clean arch.
- SOLID.
- Swegger.
- H2SQL.
- JUnit 5.

## Function

- Register player.
- List players.
- Delete player by id.
- Update player.
- Get player by id.

# End points

## Register player

```JSON
POST
/api/players/register-player

{
  "id": "string",
  "name": "string",
  "email": "string",
  "phone": "string",
  "codeName": "string",
  "playerGroup": "AVENGERS"
}
```

## List player

```JSON
GET
/api/players/list-players
```

## Get player by id

```JSON
GET
/api/players/get-player-by-id?id=
```

## Delete player by id

```JSON
DELETE
/api/players/delete-player-by-id?id=
```

## Update player

```JSON
PUT
/api/players/update-player?id=

{
  "id": "string",
  "name": "string",
  "email": "string",
  "phone": "string",
  "codeName": "string",
  "playerGroup": "AVENGERS"
}
```

# Project execution

- Copy the repository.
- Import the project in a IDE.
- Excute the project.
- Access [API document](http://localhost:8080/swagger-ui/index.html) or use a platform for API testing.

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Author

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
