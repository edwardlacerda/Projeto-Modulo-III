package com.project.DevHotel.model;

public class Reserva {
    private Long id;
    private String nome;
    private String email;
    private String dataEntrada;
    private String dataSaida;
    private String observacoes;
    private int adultos;
    private int criancas;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public String getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public int getAdultos() {
        return adultos;
    }
    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }
    public int getCriancas() {
        return criancas;
    }
    public void setCriancas(int criancas) {
        this.criancas = criancas;
    }
}
