package com.rentcar.model;

public class Hatch extends Veiculo {

    public Hatch(String marca, String modelo, String placa, double valorDiaria) {
        super(marca, modelo, placa, valorDiaria);
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return getValorDiaria() * quantidadeDias;
    }

}
