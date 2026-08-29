# 🚗 RentCar

Sistema de locação de veículos desenvolvido em Java, via console, como projeto de estudo e prática de **Programação Orientada a Objetos (POO)**.

## 📌 Sobre o projeto

O RentCar simula o funcionamento de uma locadora de veículos de pequeno porte, permitindo cadastrar clientes, cadastrar veículos de diferentes categorias, registrar e finalizar locações, e calcular valores com base em regras específicas de cada tipo de veículo.

O sistema foi pensado como uma ferramenta de **uso interno da locadora** (operada por um atendente/administrador via console), não como um aplicativo voltado ao cliente final — por isso clientes e veículos são localizados por CPF e placa, sem nenhuma camada de login.

O foco principal deste projeto é a aplicação prática dos pilares da POO:

- **Herança** — hierarquia de veículos com uma classe abstrata em comum
- **Polimorfismo** — cada categoria de veículo calcula o valor da locação de forma diferente
- **Encapsulamento** — atributos privados, com acesso controlado via getters e métodos de ação (`locar()`, `devolver()`, `finalizarLoc()`) em vez de setters genéricos
- **Composição** — `Locacao` referencia um `Cliente` e um `Veiculo`, sem herdar de nenhum dos dois
- **Abstração** — modelagem de entidades do mundo real em classes coerentes

## 🧩 Estrutura do projeto

```
src/
 └── com.rentcar/
      ├── model/
      │    ├── Veiculo.java       (classe abstrata)
      │    ├── Hatch.java
      │    ├── Sedan.java
      │    ├── Suv.java
      │    ├── Utilitario.java
      │    ├── Cliente.java
      │    └── Locacao.java
      ├── service/
      │    └── Locadora.java
      └── Main.java
```

- **model** → entidades do domínio (veículos, cliente, locação)
- **service** → regras de negócio e gerenciamento (cadastro, buscas, validações, cálculos)
- **Main** → ponto de entrada da aplicação e menu interativo via console

## 🚘 Categorias de veículos

O sistema trabalha com 4 categorias, cada uma com sua própria fórmula de cálculo do valor de locação (via polimorfismo, sobrescrevendo `calcularValorLocacao()`):

| Categoria    | Fórmula                                                        | Observações                                              |
|--------------|-----------------------------------------------------------------|-----------------------------------------------------------|
| Hatch        | `valorDiaria * quantidadeDias`                                  | Categoria de entrada                                       |
| Sedan        | `valorDiaria * quantidadeDias`                                  | Categoria intermediária                                    |
| SUV          | `(valorDiaria * quantidadeDias) + (taxaPorte * quantidadeDias)` | Taxa adicional por dia, referente ao porte do veículo      |
| Utilitário   | `(valorDiaria * quantidadeDias) + (valorPorKg * capacidadeCargaKg)` | Cobrança adicional pela capacidade de carga, voltado para transporte |

## 👤 Regras sobre o cliente

- Todo cliente tem sua idade calculada dinamicamente a partir da `dataNascimento` (não é um valor fixo armazenado)
- Para registrar uma locação, a CNH do cliente precisa ter mais de 1 ano desde a `dataEmissaoCnh` (calculado dinamicamente, comparando com a data atual)

## ⚙️ Funcionalidades

- [x] Cadastro de veículos, por categoria (Hatch, Sedan, SUV, Utilitário)
- [x] Cadastro de clientes
- [x] Registro de locação (com validação de CNH e disponibilidade do veículo)
- [x] Finalização de locação (devolvendo o veículo automaticamente)
- [x] Listagem de veículos com status (disponível/locado) e dados específicos por categoria
- [x] Histórico de locações de um cliente, com total gasto
- [x] Limite máximo de veículos cadastráveis na frota

## 🛡️ Tratamento de erros

Regras de negócio inválidas (CNH recente demais, veículo indisponível, cliente ou veículo não encontrado, limite de frota atingido, locação já finalizada) lançam `IllegalStateException`, capturadas na `Main` via `try/catch` para exibir mensagens claras sem encerrar o programa abruptamente.

## 🛠️ Tecnologias

- Java 21
- IntelliJ IDEA

## 🎯 Objetivo do projeto

Este projeto faz parte da minha trilha de estudos em Java backend, com foco em consolidar conceitos de Orientação a Objetos antes de avançar para tecnologias como Spring Boot, aplicados a um contexto próximo do mercado (sistemas do setor financeiro/corporativo).

## 👤 Autor

**Matheus Oldoni Amaral**
[GitHub](https://github.com/MatheusOldoniAmaral)