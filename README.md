# 📚 API Student

API RESTful para gerenciamento de estudantes, desenvolvida com **Spring Boot** e **Java**.

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

## 📋 Funcionalidades

- ✅ Cadastro de estudantes (POST)
- ✅ Listagem de todos os estudantes (GET)
- ✅ Busca de estudante por ID (GET)
- ✅ Atualização de estudante (PUT)
- ✅ Remoção de estudante (DELETE)

## 🛠️ Como Executar

### Pré-requisitos

- Java 17 ou superior
- Docker e Docker Compose

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/newtonfilho1310/API-Studant.git
```

2. Suba o banco de dados com Docker:
```bash
docker-compose up -d
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Acesse a API em: `http://localhost:8080`

## 📡 Endpoints

| Método | Endpoint             | Descrição                    |
|--------|----------------------|------------------------------|
| POST   | `/students`          | Cadastrar novo estudante     |
| GET    | `/students`          | Listar todos os estudantes   |
| GET    | `/students/{id}`     | Buscar estudante por ID      |
| PUT    | `/students/{id}`     | Atualizar estudante          |
| DELETE | `/students/{id}`     | Remover estudante            |

## 👨‍💻 Autor

Desenvolvido por **Newton Filho** - IMEPAC

## 📝 Licença

Este projeto é para fins educacionais.
