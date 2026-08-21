package com.rentcar.model;

public class Hatch extends Veiculo implements ElegivelParaApp{

    public Hatch(String marca, String modelo, String placa, double valorDiaria, int anoFabricacao) {
        super(marca, modelo, placa, valorDiaria, anoFabricacao);
    }

    @Override
    public double calcularValorLocacao(int quantidadeDias) {
        return getValorDiaria() * quantidadeDias;
    }

    @Override
    public boolean verificarElegibilidadeApp() {
        return (getAnoFabricacao() >= 2016);
    }
}
