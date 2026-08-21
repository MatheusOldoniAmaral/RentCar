package com.rentcar.model;

public class Utilitario extends Veiculo {

    private double valorPorKg;
    private double capacidadeCargaKg;

    public Utilitario(String marca, String modelo, String placa, double valorDiaria, double valorPorKg, double capacidadeCargaKg) {
        super(marca, modelo, placa, valorDiaria);
        this.valorPorKg = valorPorKg;
        this.capacidadeCargaKg = capacidadeCargaKg;
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return ((getValorDiaria() * quantidadeDias) + (valorPorKg * capacidadeCargaKg));
    }
}
