# API de Login

Esta é uma API de login desenvolvida com Spring Boot, Spring Security, Lombok, MVC, Java 17 e MySQL. A API oferece funcionalidades de autenticação de usuário e autorização, além de outros recursos de segurança.

## Recursos

- Autenticação de usuário com Spring Security
- Autorização baseada em roles e permissões
- Gerenciamento de sessões com Spring Boot
- Suporte a MySQL como banco de dados
- Uso de Lombok para reduzir boilerplate code
- Estrutura MVC com Spring Boot

## Configuração

Certifique-se de ter o seguinte instalado:

- Java 17 ou superior
- MySQL 5.7 ou superior

## Uso

Uma vez que o projeto esteja em execução, você pode acessar os endpoints da API conforme especificado abaixo.

## Endpoints

- **/usuarios/cadastrar**: Endpoint para cadastro de usuário.
  - Método `POST`
  - JSON `{"nome": "nome_usuario", "email": "email@email.com", "senha": "senha_secreta", "role": "ADMIN or USER"}`
  - Retorna o usuario cadastrado.


- **/auth**: Endpoint para autenticação de usuário.
  - Método: `POST`
  - JSON: `{ "email": "email@email.com", "senha": "senha_secreta" }`
  - Retorna um token JWT se a autenticação for bem-sucedida.

  - **/usuarios/admin**: Endpoint para fazer a requisição de administrador.
  - Método: `GET`
  - Authorization - `Bearer`
  - Retorna sucesso caso seja um usuario ADMIN.

  - **/usuarios/user**: Endpoint para fazer a requisição de usuario.
  - Método: `GET`
  - Authorization - `Bearer`
  - Retorna sucesso caso seja um usuario ADMIN or USER.

## Tecnologias

- **Spring Boot**: Framework de aplicação para Java.
- **Spring Security**: Biblioteca para autenticação e autorização.
- **Java-JWT**: Geração do Token.
- **Lombok**: Biblioteca para redução de código boilerplate.
- **MVC**: Padrão de projeto Model-View-Controller.
- **Java 17**: Versão utilizada para desenvolvimento.
- **MySQL**: Banco de dados relacional.