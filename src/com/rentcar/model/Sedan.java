package com.rentcar.model;

public class Sedan extends Veiculo {

    public Sedan(String marca, String modelo, String placa, double valorDiaria) {
        super(marca, modelo, placa, valorDiaria);
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return getValorDiaria() * quantidadeDias;
    }
}




