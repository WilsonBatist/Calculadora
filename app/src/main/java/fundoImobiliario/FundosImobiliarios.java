package com.example.calculadoradeinvestimento.fundosImobiliario;

public class FundosImobiliarios {
    private String nome;
    private String sigla;
    private double valorCota;
    private String dataAquisicao;

    public FundosImobiliarios() {
    }

    public FundosImobiliarios(String nome, String sigla, double valorCota, String dataAquisicao) {
        this.nome = nome;
        this.sigla = sigla;
        this.valorCota = valorCota;
        this.dataAquisicao = dataAquisicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public double getValorCota() {
        return valorCota;
    }

    public void setValorCota(double valorCota) {
        this.valorCota = valorCota;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
