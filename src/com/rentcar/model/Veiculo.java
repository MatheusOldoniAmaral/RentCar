package com.rentcar.model;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private String placa;
    private double valorDiaria;
    private boolean disponivel;

    public void locar() {
        if (!disponivel) {
            throw new IllegalStateException("Não é possível locar: veículo já está em uso.");
        } else {
            disponivel = false;
            System.out.println("Locação realizada com sucesso.");
        }
    }

    public void devolver() {
        if (disponivel) {
            throw new IllegalStateException("Não é possível devolver: veículo não está locado.");
        } else {
            disponivel = true;
            System.out.println("Devolução registrada com sucesso.");
        }
    }

    public Veiculo(String marca, String modelo, String placa, double valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public abstract double calcularValorLocacao(int quantidadeDias);
}
