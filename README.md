<h1 align="center">
  <br>
  📚 API Student 
  <br>
</h1>

<h4 align="center">Sistema de Gerenciamento de Alunos desenvolvido com <a href="https://spring.io/projects/spring-boot" target="_blank">Spring Boot</a>.</h4>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL" />
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
</p>

<p align="center">
  <a href="#-sobre-o-projeto">Sobre</a> •
  <a href="#-funcionalidades">Funcionalidades</a> •
  <a href="#-como-executar">Como Executar</a> •
  <a href="#-endpoints">Endpoints</a> •
  <a href="#-arquitetura">Arquitetura</a> •
  <a href="#-autor">Autor</a>
</p>

---

## 📖 Sobre o Projeto

A **API Student** é um serviço RESTful projetado para gerenciar registros de estudantes em uma instituição de ensino. Este projeto foi desenvolvido como parte de atividades acadêmicas do IMEPAC, com o objetivo de aplicar na prática os conceitos fundamentais do desenvolvimento backend moderno em Java, incluindo injeção de dependências, mapeamento objeto-relacional (ORM) e tratamento global de exceções.

## 🚀 Funcionalidades

O sistema provê um CRUD (Create, Read, Update, Delete) completo:

- **[POST] Cadastro:** Inclusão de novos estudantes com validação de dados.
- **[GET] Listagem:** Recuperação de todos os estudantes cadastrados.
- **[GET] Busca Específica:** Consulta de estudantes por ID com tratamento adequado caso não seja encontrado (HTTP 404).
- **[PUT] Atualização:** Edição de dados de um estudante existente.
- **[DELETE] Remoção:** Exclusão segura de registros.

## 🛠️ Como Executar

### Pré-requisitos

Para rodar o projeto localmente, você precisará das seguintes ferramentas instaladas:
- [Java 17](https://adoptium.net/) ou superior
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
- [Git](https://git-scm.com/)

### Passos da Instalação

1. **Clone o repositório:**
```bash
git clone https://github.com/newtonfilho1310/API-Studant.git
cd API-Studant
```

2. **Inicie a infraestrutura de banco de dados:**
> O projeto utiliza o Docker Compose para subir uma instância do PostgreSQL facilmente.
```bash
docker-compose up -d
```

3. **Execute a aplicação via Maven Wrapper:**
```bash
./mvnw spring-boot:run
```

4. **Acesse a API:**
O servidor estará rodando na porta `8080`.
Base URL: `http://localhost:8080`

---

## 📡 Endpoints da API

Abaixo estão as rotas disponíveis. Todos os retornos e envios são no formato `JSON`.

| Método | Endpoint             | Descrição                                 |
| :---   | :---                 | :---                                      |
| `POST` | `/students`          | Cria um novo estudante no banco de dados. |
| `GET`  | `/students`          | Retorna a lista de todos os estudantes.   |
| `GET`  | `/students/{id}`     | Retorna os detalhes de um estudante.      |
| `PUT`  | `/students/{id}`     | Atualiza as informações de um estudante.  |
| `DELETE`| `/students/{id}`    | Remove um estudante pelo seu ID.          |

<details>
<summary><b>Exemplo de Payload (POST / PUT)</b></summary>

```json
{
  "name": "João da Silva",
  "email": "joao.silva@email.com",
  "enrollment": "2023001"
}
```
</details>

<details>
<summary><b>Exemplo de Resposta de Erro (Tratamento Global)</b></summary>

```json
{
  "timestamp": "2026-04-26T14:30:00.000Z",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with ID: 99",
  "path": "/students/99"
}
```
</details>

---

## 🏗️ Arquitetura

O projeto segue a arquitetura de camadas padrão (Layered Architecture) do Spring:

- **Controllers (`/controllers`):** Recebem as requisições HTTP e definem as rotas.
- **Services (`/services`):** Contêm a regra de negócio da aplicação.
- **Repositories (`/repositories`):** Interfaces Spring Data JPA para comunicação com o PostgreSQL.
- **Models/Entities (`/entities`):** Classes que representam as tabelas do banco.
- **Exceptions (`/exceptions`):** Tratamento global e padronizado de erros utilizando `@ControllerAdvice`.

---

## 🤝 Como Contribuir

Sinta-se à vontade para contribuir! Consulte nosso arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para ver como você pode propor melhorias ou relatar problemas.

## 👨‍💻 Autor

Feito com ☕ e código por **Newton Filho** - Estudante de ADS no IMEPAC.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/SEU_LINKEDIN_AQUI/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/newtonfilho1310)

## 📝 Licença

Este projeto é desenvolvido para fins educacionais e de estudo.

---
