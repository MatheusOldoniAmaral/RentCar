package com.rentcar.service;

import com.rentcar.model.Cliente;
import com.rentcar.model.Locacao;
import com.rentcar.model.Veiculo;

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
}
