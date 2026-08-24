package com.rentcar.service;

import com.rentcar.model.Cliente;
import com.rentcar.model.Locacao;
import com.rentcar.model.Veiculo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Locadora {

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Locacao> locacoes = new ArrayList<>();

    private static final int LIMITE_VEICULOS = 10;

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculos.size() >= LIMITE_VEICULOS) {
            throw new IllegalStateException("Limite de veículos cadastrados atingido.");
        }
        veiculos.add(veiculo);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    private boolean cnhValida(Cliente cliente) {
        Period periodo = Period.between(cliente.getDataEmissaoCnh(), LocalDate.now());
        return periodo.getYears() >= 1;
    }

    public void registrarLocacao(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, int quantidadeDias) {
        if (!cnhValida(cliente)) {
            throw new IllegalStateException("Não é possível locar: CNH do cliente ainda não completou 1 ano desde a emissão.");
        }
        veiculo.locar();
        Locacao locacao = new Locacao(cliente, veiculo, dataInicio, quantidadeDias);
        locacoes.add(locacao);
    }

    public void finalizarLocacao(int id) {
        boolean encontrada = false;
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                locacao.finalizarLoc();
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            throw new IllegalStateException("Não é possível finalizar: locação com o ID informado não foi encontrada.");
        }
    }

    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public List<Locacao> historicoClientes(Cliente cliente) {
        List<Locacao> historico = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            if (locacao.getCliente() == cliente) {
                historico.add(locacao);
            }
        }

        return historico;
    }

    public double totalGastoPorCliente(Cliente cliente) {
        double soma = 0;

        for (Locacao locacao : locacoes) {
            if (locacao.getCliente() == cliente) {
                soma += locacao.getValorTotal();
            }
        }
        return soma;
    }
}
