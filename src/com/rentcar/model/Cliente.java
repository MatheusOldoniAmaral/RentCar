package com.rentcar.model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private long cpf;
    private long numeroCnh;
    private String categoriaCnh;
    private LocalDate dataValidadeCnh;
    private LocalDate dataEmissaoCnh;
    private long telefone;
    private String email;
    private String endereco;

    public Cliente(String nome, LocalDate dataNascimento, long cpf, long numeroCnh, String categoriaCnh, LocalDate dataValidadeCnh, LocalDate dataEmissaoCnh, long telefone, String email, String endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.numeroCnh = numeroCnh;
        this.categoriaCnh = categoriaCnh;
        this.dataValidadeCnh = dataValidadeCnh;
        this.dataEmissaoCnh = dataEmissaoCnh;
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

    public long getNumeroCnh() {
        return numeroCnh;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public LocalDate getDataValidadeCnh() {
        return dataValidadeCnh;
    }

    public LocalDate getDataEmissaoCnh() {
        return dataEmissaoCnh;
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
