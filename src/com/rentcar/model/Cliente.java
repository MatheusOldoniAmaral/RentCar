package com.rentcar.model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private long cpf;
    private String categoriaCnh;
    private LocalDate dataValidadeCnh;
    private LocalDate dataCnhDefinitiva;
    private long telefone;
    private String email;
    private String endereco;

    public Cliente(String nome, LocalDate dataNascimento, long cpf, String categoriaCnh, LocalDate dataValidadeCnh, LocalDate dataCnhDefinitiva, long telefone, String email, String endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.categoriaCnh = categoriaCnh;
        this.dataValidadeCnh = dataValidadeCnh;
        this.dataCnhDefinitiva = dataCnhDefinitiva;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        Period periodo = Period.between(dataNascimento, LocalDate.now());
        return periodo.getYears();
    }

    public long getCpf() {
        return cpf;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public LocalDate getDataValidadeCnh() {
        return dataValidadeCnh;
    }

    public LocalDate getDataCnhDefinitiva() {
        return dataCnhDefinitiva;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }
}
