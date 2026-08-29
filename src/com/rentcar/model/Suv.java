package com.rentcar.model;

public class Suv extends Veiculo {

    private double taxaPorte;

    public Suv(String marca, String modelo, String placa, double valorDiaria, int anoFabricacao, double taxaPorte) {
        super(marca, modelo, placa, valorDiaria, anoFabricacao);
        this.taxaPorte = taxaPorte;
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return ((getValorDiaria() * quantidadeDias) + (taxaPorte * quantidadeDias));
    }

    public double getTaxaPorte() {
        return taxaPorte;
    }
}
