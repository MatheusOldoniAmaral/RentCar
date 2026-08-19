# 🚗 RentCar

Sistema de locação de veículos desenvolvido em Java, via console, como projeto de estudo e prática de **Programação Orientada a Objetos (POO)**.

## 📌 Sobre o projeto

O RentCar simula o funcionamento de uma locadora de veículos de pequeno porte, permitindo cadastrar clientes, veículos de diferentes categorias, registrar locações e devoluções, e calcular valores com base em regras específicas de cada tipo de veículo.

O foco principal deste projeto é a aplicação prática dos pilares da POO:

- **Herança** — hierarquia de veículos com uma classe abstrata em comum
- **Polimorfismo** — cada categoria de veículo calcula o valor da locação de forma diferente
- **Encapsulamento** — atributos privados com acesso controlado via getters/setters
- **Interfaces** — comportamento compartilhado entre categorias distintas de veículos
- **Abstração** — modelagem de entidades do mundo real em classes coerentes

## 🧩 Estrutura do projeto

```
src/
 └── com.rentcar/
      ├── model/
      │    ├── Veiculo.java          (classe abstrata)
      │    ├── Hatch.java
      │    ├── Sedan.java
      │    ├── Suv.java
      │    ├── Utilitario.java
      │    ├── ElegivelParaApp.java  (interface)
      │    ├── Cliente.java
      │    └── Locacao.java
      ├── service/
      │    └── Locadora.java
      └── Main.java
```

- **model** → entidades do domínio (veículos, cliente, locação)
- **service** → regras de negócio e gerenciamento (cadastro, cálculo, listagens)
- **Main** → ponto de entrada da aplicação e menu interativo via console

## 🚘 Categorias de veículos

O sistema trabalha com 4 categorias, cada uma com sua própria fórmula de cálculo de valor de locação:

| Categoria    | Observações                                                   |
|--------------|----------------------------------------------------------------|
| Hatch        | Veículo de passeio, categoria de entrada                       |
| Sedan        | Veículo de passeio, categoria intermediária                    |
| SUV          | Veículo de maior porte, com taxa adicional na fórmula de cálculo |
| Utilitário   | Veículo voltado para transporte de carga                       |

> As fórmulas específicas de cada categoria estão em desenvolvimento e serão detalhadas aqui conforme implementadas.

## ⚙️ Funcionalidades

- [ ] Cadastro de clientes
- [ ] Cadastro de veículos (por categoria)
- [ ] Registro de locação
- [ ] Registro de devolução
- [ ] Listagem de veículos com status (disponível/locado)
- [ ] Histórico de locações por cliente
- [ ] Cálculo do valor total de uma locação
- [ ] Cálculo do total gasto por cliente

## 🛠️ Tecnologias

- Java 21
- IntelliJ IDEA

## 🎯 Objetivo do projeto

Este projeto faz parte da minha trilha de estudos em Java backend, com foco em consolidar conceitos de Orientação a Objetos antes de avançar para tecnologias como Spring Boot, aplicados a um contexto próximo do mercado (sistemas do setor financeiro/corporativo).

## 👤 Autor

**Matheus Oldoni Amaral**
[GitHub](https://github.com/MatheusOldoniAmaral)

---

*Projeto em desenvolvimento — este README será atualizado conforme o progresso.*
