package com.rentcar.model;

public class Sedan extends Veiculo {

    public Sedan(String marca, String modelo, String placa, double valorDiaria, int anoFabricacao) {
        super(marca, modelo, placa, valorDiaria, anoFabricacao);
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return getValorDiaria() * quantidadeDias;
    }
}




