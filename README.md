# API REST de clientes e funcionários (Spring)

Duas APIs REST feitas em aula (Unisenai), com as quatro operações básicas de um CRUD e respostas HTTP adequadas.

## Rotas

| Método | Rota | O que faz | Resposta |
| --- | --- | --- | --- |
| GET | `/cliente` | lista os clientes | 200 |
| GET | `/cliente/{id}` | busca um cliente | 200 ou 404 |
| POST | `/cliente` | cadastra um cliente | 201 |
| PUT | `/cliente/{id}` | atualiza um cliente | 200 ou 404 |
| DELETE | `/cliente/{id}` | remove um cliente | 204 ou 404 |

O recurso de funcionários segue o mesmo padrão, com o caminho `/funcionarios`.

Exemplo de corpo (JSON) para cadastrar:
```json
{ "id": 1, "nome": "Maria" }
```

A documentação completa está em [`docs/documentacao-api.pdf`](docs/documentacao-api.pdf).

## Tecnologias
Java 21, Spring Boot 4.1 (Spring Web) e Maven

## Estrutura
```
src/main/java/br/com/senaisp/bauru/equipamento/
├── controllers/   rotas da API
├── services/      regras de negócio
├── repositories/  armazenamento dos dados
└── models/        Cliente e Funcionario
```

## Como rodar
1. Tenha o JDK 21 instalado e abra o projeto em uma IDE com Maven.
2. Rode a classe `EquipamentoApplication` pela IDE, ou use no terminal: `./mvnw spring-boot:run` (no Windows: `mvnw.cmd spring-boot:run`).
3. Teste as rotas em `http://localhost:8080` com o Postman, o Insomnia ou o `curl`:
   ```
   curl http://localhost:8080/cliente
   ```

## Limitações e próximos passos
- Os dados ficam **em memória** e são perdidos quando a aplicação reinicia. O próximo passo é ligar a API a um banco de dados.
- Ainda não há validação dos campos enviados.
