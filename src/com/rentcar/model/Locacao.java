package com.rentcar.model;

import java.time.LocalDate;

public class Locacao {

    private static int proximoId = 1;

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private int quantidadeDias;
    private boolean locFinalizada;
    private double valorTotal;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, int quantidadeDias) {
        this.id = proximoId;
        proximoId++;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.quantidadeDias = quantidadeDias;
        this.locFinalizada = false;
        this.valorTotal = veiculo.calcularValorLocacao(quantidadeDias);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public boolean isLocFinalizada() {
        return locFinalizada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void finalizarLoc() {
        if (locFinalizada) {
            throw new IllegalStateException("Não é possível finalizar: locação já está finalizada.");
        } else {
            veiculo.devolver();
            locFinalizada = true;
            System.out.println("Locação finalizada com sucesso.");
        }
    }
}
