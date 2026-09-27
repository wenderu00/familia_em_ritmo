<p align="center">
  <img src="familia_em_ritmo_front/assets/Logo.png" alt="Logo do Família em Ritmo" width="140">
</p>

<h1 align="center">Família em Ritmo</h1>

<p align="center">
  <a href="https://github.com/wenderu00/familia_em_ritmo/actions/workflows/ci.yml"><img src="https://github.com/wenderu00/familia_em_ritmo/actions/workflows/ci.yml/badge.svg" alt="CI"></a>
  <img src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring_Boot-3.4-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 3.4">
  <img src="https://img.shields.io/badge/Flutter-02569B?logo=flutter&logoColor=white" alt="Flutter">
</p>

App que ajuda pais e responsáveis a organizar a rotina das crianças (sono, alimentação,
estudo, higiene, lazer) com uma interface lúdica. O repositório tem a **API em Spring
Boot** e o **app em Flutter**.

## Backend

API REST em Java 17 + Spring Boot 3.4, com JPA sobre H2 e documentação OpenAPI
(springdoc). O código está em `familia_em_ritmo_back/Spring_back/` e se organiza em
três camadas:

```
application/controller   ChildController, RelativeController (HTTP)
domain/model             Child, Relative, rotinas e missões por categoria
domain/service           regras e orquestração
domain/repository        repositórios Spring Data JPA
infra/dto                um DTO de entrada/saída por caso de uso (create, get_by_id, put_name…)
```

| Recurso | Endpoints |
|---|---|
| `/child` | listar, criar, buscar por id, alterar nome e idade, remover |
| `/relative` | listar, criar, buscar por id, alterar nome, remover, adicionar e remover observador de uma criança |

O domínio de rotinas e missões (9 categorias cada) já está modelado e é a próxima parte a
ganhar endpoints.

### Rodando

```bash
cd familia_em_ritmo_back/Spring_back
./mvnw spring-boot:run     # http://localhost:8080
./mvnw test                # testes de contexto e de API (REST Assured, porta aleatória)
```

Swagger UI em http://localhost:8080/swagger-ui.html e o console do H2 em `/h2-console`.

## App

App Flutter em `familia_em_ritmo_front/`, com telas de splash, crianças, rotinas, perfil e
troca de senha.

```bash
cd familia_em_ritmo_front
flutter pub get
flutter run
```

## Stack

Java 17 · Spring Boot 3.4 (Web, Data JPA, Actuator) · H2 · Lombok · springdoc-openapi ·
JUnit 5 + REST Assured · Flutter · GitHub Actions

## Autores

Projeto em grupo de [Márcio Wendell](https://github.com/wenderu00) e Peterson Henrique.
