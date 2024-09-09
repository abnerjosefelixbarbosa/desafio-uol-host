# Challenge uol host

## Sobre

Desafio técnico UOL host.

## Modelo

![host_UOL_class_diagram](https://github.com/user-attachments/assets/ff55984e-9ad8-4ed0-82ac-e261ed2b7f90)

## Link do desafio

[link](https://github.com/uolhost/test-backEnd-Java)

# Recurso do projeto 

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

## Funções

- Register player.
- List players.
- Delete player by id.
- Update player.
- Get player by id.

# Requesições

## Registrar jogador

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

## Listar jogador player

```JSON
GET
/api/players/list-players
```

## Obter jogador pelo id

```JSON
GET
/api/players/get-player-by-id?id=
```

## Deletar jogador pelo id

```JSON
DELETE
/api/players/delete-player-by-id?id=
```

## Atualizar jogador pelo id

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

# Execução do projeto

- Copie e execute repositório em uma IDE.
- Acesse [a docmentação da API](http://localhost:8080/swagger-ui/index.html) ou use outra plataforma para testa a API.

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Autor

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
