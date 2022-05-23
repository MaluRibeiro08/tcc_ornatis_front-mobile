package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Servico {

    @SerializedName("acao")
    @Expose
    private String acao;

    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

    @SerializedName("id_servico")
    @Expose
    private int id_servico;

    @SerializedName("nome_servico")
    @Expose
    private String nome_servico;

    @SerializedName("preco")
    @Expose
    private float preco;

    @SerializedName("desconto")
    @Expose
    private int desconto;

    @SerializedName("tempo_duracao")
    @Expose
    private int tempo_duracao;

    @SerializedName("detalhes")
    @Expose
    private String detalhes;

    //PÚBLICO ALVO
//    @SerializedName("publico_alvo")
//    @Expose
//    private ArrayList publico_alvo;

    //CATEGORIA
//    @SerializedName("especialidade")
//    @Expose
//    private ArrayList especialidade;

    //PARTE DO CORPO
//    @SerializedName("parte_corpo")
//    @Expose
//    private ArrayList parte_corpo;


    //LISTA DE FUNCIONÁRIO
    //LOCAL DE ATENDIMENTO


    @SerializedName("intervalo")
    @Expose
    private int intervalo;

    @SerializedName("imagem_servico")
    @Expose
    private String imagem_servico;

    public Servico() {
    }

    public Servico(String acao, int id_empresa, int id_servico, String nome_servico,
                   float preco, int desconto, int tempo_duracao,
                   String detalhes, ArrayList publico_alvo, ArrayList especialidade,
                   ArrayList parte_corpo, int intervalo, String imagem_servico) {
        this.acao = acao;
        this.id_empresa = id_empresa;
        this.id_servico = id_servico;
        this.nome_servico = nome_servico;
        this.preco = preco;
        this.desconto = desconto;
        this.tempo_duracao = tempo_duracao;
        this.detalhes = detalhes;
//        this.publico_alvo = publico_alvo;
//        this.especialidade = especialidade;
//        this.parte_corpo = parte_corpo;
        this.intervalo = intervalo;
        this.imagem_servico = imagem_servico;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getTempo_duracao() {
        return tempo_duracao;
    }

    public void setTempo_duracao(int tempo_duracao) {
        this.tempo_duracao = tempo_duracao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }


//    public ArrayList getPublico_alvo() {
//        return publico_alvo;
//    }
//
//    public void setPublico_alvo(ArrayList publico_alvo) {
//        this.publico_alvo = publico_alvo;
//    }


    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public String getImagem_servico() {
        return imagem_servico;
    }

    public void setImagem_servico(String imagem_servico) {
        this.imagem_servico = imagem_servico;
    }
}
