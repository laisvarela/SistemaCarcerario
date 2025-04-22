# Sistema Carcerário

Projeto desenvolvido como parte da **Atividade Avaliativa I** da disciplina de **Desenvolvimento de Sistemas Orientado a Objetos**.

## 📋 Descrição
Este projeto consiste em um sistema carcerário simples, implementado em Java, com foco na aplicação dos principais conceitos da Programação Orientada a Objetos. O sistema permite o gerenciamento de celas, prisioneiros e guardas, com validações específicas e uso de exceções personalizadas.

## ⚙️ Tecnologias Utilizadas
- **Java**
- **Visual Studio Code (VSCode)**
  - Extensão **Draw.io Integration** para criação do diagrama UML
  - Extensões para suporte à linguagem Java

## 📌 Conceitos Aplicados

- **Classe Abstrata:**  
  A classe `Pessoa` é abstrata e serve como base para `Guarda` e `Prisioneiro`, com atributos comuns como nome, CPF e data de nascimento.

- **Interface:**  
  A interface `Registro` define o método `gerarRelatorio()`, implementado pelas classes `Guarda`, `Prisioneiro` e `Cela`.

- **Exceções Personalizadas:**
  - `TurnoInvalidoException`: quando há tentativa de cadastrar um guarda em um turno já ocupado.
  - `CelaLotadaException`: quando a cela atinge sua capacidade máxima.
  - `RegistroInvalidoException`: para CPF, matrícula ou número de registro duplicados.
  - `GuardaNaoEncontradoException`: ao tentar remover um guarda de um turno vazio.

- **Encapsulamento e Validações:**  
  A classe `SistemaCarcerario` centraliza a lógica de controle, validação de dados e lançamentos de exceções, garantindo a integridade do sistema.

## 📎 Diagrama UML
O diagrama UML do projeto foi desenvolvido utilizando a extensão **Draw.io** no VSCode. Ele ilustra as relações entre as classes, heranças, métodos e atributos principais.

## 🚀 Funcionalidades Principais

- Adicionar/remover prisioneiros, respeitando a capacidade da cela.
- Adicionar/remover guardas, com validação de turnos e dados únicos.
- Geração de relatórios individuais e compostos pelas classes via interface `Registro`.
- Exceções personalizadas para garantir a integridade dos dados.

