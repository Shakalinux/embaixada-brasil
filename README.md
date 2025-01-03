# Descrição do Projeto: **Embaixada**

**Embaixada** é uma aplicação web construída utilizando o framework **Spring Boot**, projetada para gerenciar serviços, perfis de usuários e suas interações com documentos como passaportes, além de permitir a solicitação de serviços e agendamento de atividades. O sistema envolve a interação entre usuários, administradores e serviços oferecidos, focando na gestão de perfis e passaportes dos usuários, agendamento de serviços e validação do status de documentos.

## Funcionalidades Principais

### 1. **Cadastro e Autenticação de Usuário**
- O sistema permite que novos usuários se cadastrem, criando um perfil e atribuindo um passaporte inicialmente **bloqueado**. Após o cadastro, o usuário pode acessar a aplicação por meio de um sistema de login seguro.
- **Cadastro de Usuário**: O usuário se cadastra inserindo informações como nome, e-mail, senha, etc. Um perfil e um passaporte são automaticamente criados.
- **Login**: O sistema autentica o usuário com base nas credenciais (e-mail e senha).

### 2. **Gestão de Serviços**
- O sistema oferece uma lista de **serviços** que podem ser visualizados pelos usuários. Cada serviço pode ter uma descrição e imagem associada, permitindo o agendamento de atividades.
    - **Exibição de Serviços**: Todos os serviços são listados na página inicial da aplicação.
    - **Agendamento de Serviços**: O usuário pode agendar um serviço específico, associando-o ao seu perfil.
    - **Visualização de Detalhes do Serviço**: Cada serviço pode ser visualizado detalhadamente, com a opção de agendamento e comentários.

### 3. **Gestão de Perfil de Usuário**
- O usuário pode editar seu perfil, incluindo nome, endereço, telefone e foto (avatar). Essas informações são salvas no banco de dados, e o avatar pode ser visualizado em forma de imagem base64.
    - **Exibição do Perfil**: O usuário pode visualizar informações detalhadas do seu perfil, incluindo passaporte e serviços agendados.
    - **Edição do Perfil**: O usuário pode atualizar informações pessoais, como nome, endereço e telefone. O avatar (imagem de perfil) também pode ser atualizado.

### 4. **Gestão de Passaporte**
- A aplicação permite que o status do passaporte de cada usuário seja verificado e alterado. O passaporte pode estar **bloqueado** ou **ativo** e essa alteração pode ser feita por administradores ou pelo próprio usuário, dependendo do fluxo do sistema.
    - **Exibição e Alteração de Status**: O passaporte do usuário pode ser visualizado, e seu status pode ser alterado entre "bloqueado" e "ativo".

### 5. **Tela Inicial e Navegação**
- A tela inicial do sistema apresenta todos os serviços disponíveis e permite que os usuários interajam com eles, além de acessar outras seções como "Contato" e "Sobre". A navegação é simples e intuitiva, permitindo fácil acesso às funcionalidades essenciais do sistema.

---

## Estrutura do Projeto

A aplicação segue a arquitetura **MVC (Model-View-Controller)** e utiliza as seguintes tecnologias:

- **Spring Boot**: Framework principal para desenvolvimento da aplicação.
- **Spring Security**: Para gerenciar a autenticação e autorização de usuários.
- **Spring Data JPA**: Para interação com o banco de dados, facilitando operações de CRUD (Create, Read, Update, Delete).
- **Thymeleaf**: Motor de templates para renderização de páginas HTML.
- **Base64**: Para codificar e exibir imagens de forma eficiente, como avatares e imagens associadas aos serviços.

---

## Estrutura de Pastas

- **Controller**: Contém os controllers responsáveis por lidar com as requisições HTTP e a lógica de negócios.
- **Model**: Contém as classes que representam os dados do sistema, como `User`, `Profile`, `PassPort`, `Service`, entre outros.
- **Repository**: Responsável pela persistência de dados utilizando o Spring Data JPA.
- **View (Templates)**: Contém as páginas HTML renderizadas, que utilizam o Thymeleaf para exibição de dados dinâmicos.

---

## Tecnologias Utilizadas

- **Spring Boot**: Framework para simplificar o desenvolvimento de aplicações Java.
- **Spring Security**: Para segurança da aplicação, incluindo autenticação de usuários.
- **Spring Data JPA**: Para fácil acesso a dados no banco de dados relacional.
- **Thymeleaf**: Para renderizar a interface do usuário com HTML dinâmico.
- **Base64**: Para representar imagens binárias em formato textual, como avatares de perfil e imagens de serviços.

---

## Como Executar o Projeto

### 1. **Clonar o Repositório**:
   - Execute o comando: 
     ```bash
     git clone https://github.com/seu-repositorio/embaixada.git
     ```

### 2. **Configurar o Banco de Dados**:
   - O projeto usa um banco de dados relacional. Configure a conexão do banco de dados no arquivo `application.properties`.

### 3. **Rodar o Projeto**:
   - Com o ambiente configurado, execute a aplicação:
     ```bash
     ./mvnw spring-boot:run
     ```
   - A aplicação estará disponível em `http://localhost:8080`.

### 4. **Acessar a Aplicação**:
   - Acesse a aplicação pelo navegador e utilize a interface para cadastrar usuários, agendar serviços e interagir com os dados.

---

### Imagens do projeto
Projeto em situação final, modelo de algumas rotas.

<div style="width:100%; overflow:hidden; max-width:600px;">
  <div style="display: flex; transition: transform 0.5s ease;">
    <img src="https://i.postimg.cc/BbTzY3mV/1.png" alt="Imagem 1" style="width:100%; flex-shrink: 0; border: 5px solid black;">
    <img src="https://i.postimg.cc/brcM9r9n/2.png" alt="Imagem 2" style="width:100%; flex-shrink: 0; border: 5px solid black;">
    <img src="https://i.postimg.cc/0ycT189g/3.png" alt="Imagem 3" style="width:100%; flex-shrink: 0; border: 5px solid black;">
    <img src="https://i.postimg.cc/26BMWhhm/4.png" alt="Imagem 4" style="width:100%; flex-shrink: 0; border: 5px solid black;">
    <img src="https://i.postimg.cc/HLNFjBJB/5.png" alt="Imagem 5" style="width:100%; flex-shrink: 0; border: 5px solid black;">
    <img src="https://i.postimg.cc/PqJBtBqC/6.png" alt="Imagem 6" style="width:100%; flex-shrink: 0; border: 5px solid black;">
  </div>
</div>
