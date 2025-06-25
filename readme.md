# Sistema Carcerário

Projeto desenvolvido como parte da **Atividade Avaliativa I e II** da disciplina de **Desenvolvimento de Sistemas Orientado a Objetos**.

## 📋 Descrição
Este projeto consiste em um sistema carcerário simples, implementado em Java, com utilização de interface gráfica através do java swing GUI e integração com o banco de dados. 

## ⚙️ Tecnologias Utilizadas
- **Java**
- **Visual Studio Code (VSCode)**
  - Extensão **Draw.io Integration** para criação do diagrama UML
  - Extensões para suporte à linguagem Java
- **NetBeans**
  - JDK
  - Driver JDBC para conexão com o banco de dados.
- **MySQL Workbench**
- **phpMyAdmin**

## 📌 Conceitos Aplicados

- **Classe Abstrata:**  
  A classe `Pessoa` é abstrata e serve como base para `Guarda` e `Prisioneiro`, com atributos comuns como nome, CPF e data de nascimento.

- **Interface:**  
  A interface `Registro` define o método `gerarRelatorio()`, implementado pelas classes `Guarda`, `Prisioneiro` e `Cela`.
  A interface `AtualizavelListener`define o método `dadosAtualizados()` e é implementado pelas classes `GuardaView`, `PrisioneiroView`, `CelaView` e `SistemaCarcerarioView`.

- **MVC:**  
  O projeto é distribuídos em pacotes seguindo a arquitetura `MVC`, para melhor organização e manipulação de classes.
  Segue os pacotes implementados:
    - *controller*: é invocado na view e faz a requisição para o model. 
    - *dao*: faz a conexão e comandos sql com o banco de dados.
    - *listener*: atualiza todos os liteners cadastrados através do método `dadosAtualizados()`.
    - *model*: criação e encapsulamento dos objetos `Guarda`, `Prisioneiro` e `Cela`.
    - *view*: responsável pela representação gráfica e interação com o usuário.

## 📎 Diagrama UML
O diagrama UML do projeto foi desenvolvido utilizando a extensão **Draw.io** no VSCode. Ele ilustra as relações entre as classes, heranças, métodos e atributos principais. Encontra-se disponível no arquivo `Avaliação 1 - Relatório.pdf`

## 🚀 Funcionalidades Principais

- Adicionar/remover/editar/buscar/listar prisioneiros.
- Adicionar/remover/editar/buscar/listar guardas.
- Adicionar/remover/editar/buscar/listar celas.
- Geração de relatórios individuais e compostos pelas classes via interface `Registro`.

## Como Executar

### Banco de dados 
## MySQL Workbench
  1. Caso não tenha a aplicação, baixe pelo site: https://dev.mysql.com/downloads/workbench/
  2. Siga as instruções de instalação e crie um usuário e uma senha, certifique-se de anotar em um lugar seguro
  3. Selecione sua conexão e localize `Query`
  4. Digite o seguinte comando SQL: grant all on * . * to 'youruser'@'localhost' e execute
  5. Para visualizar o schemas, clique ctrl+R
  6. Para conectar o projeto ao banco de dados, é preciso um driver de conexão: https://dev.mysql.com/downloads/connector/j/
  7. No site, em `Select Operating System`, selecione `Platform Independent` e baixe qualquer uma das opções
     
## phpMyAdmin
  1. Caso não possua a aplicação, baixe pelo site: https://www.phpmyadmin.net/downloads/ 
  2. Execute o xampp como Administrador
  3. Clique `start` em `Apache` e `MySQL`
  4. Selecione `admin` ou insira `localhost/phpmyadmin`no seu navegador para ter acesso
     
### NetBeans IDE
  1. Caso não possua a IDE, baixe pelo site: https://netbeans.apache.org/front/main/download/ 
  2. Abra o **NetBeans**.
  3. Vá em **Team**, identifique **Git** e selecione **Clone**.
  4. Em **Repository URL** insira: https://github.com/laisvarela/SistemaCarcerario.git
  5. Com o pojeto aberto, localize a pasta **Libaries** ou **Biblioteca**, clique com o botão direito do mouse e selecione ADD JAR/Folder
  6. Navegue até o driver de conexão baixado anteriormente e selecione o arquivo JAR
  7. No pacote **dao**, selecione **ConexaoDAO**, localize o SQL user e senha e coloque seu usuário e sua senha para conexão com o banco de dados
  8. Clique no ícone `run` na barra superior 
  9. A saída do programa será apresentada através da interface gráfica. 
