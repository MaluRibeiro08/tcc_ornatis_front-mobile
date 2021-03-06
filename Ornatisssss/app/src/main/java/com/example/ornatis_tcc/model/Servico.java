package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Servico {

    @SerializedName("acao")
    @Expose
    private String acao;

    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

    @SerializedName("id_especialidade")
    @Expose
    private int id_especialidade;

    @SerializedName("nome_especialidade")
    @Expose
    private String nome_especialidade;

    @SerializedName("id_parte_corpo")
    @Expose
    private int id_parte_corpo;

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
    @SerializedName("generos")
    @Expose
    private ArrayList<Genero> publico_alvo;

    //CATEGORIA
    @SerializedName("especialidade")
    @Expose
    private List especialidade;

    @SerializedName("ativo_para_uso")
    @Expose
    private int ativo_para_uso;


    //LISTA DE FUNCIONÁRIO
    @SerializedName("funcionarios")
    @Expose
    private ArrayList<Funcionario> funcionarios;

    @SerializedName("tipos_atendimento")
    @Expose
    private ArrayList<TipoAtendimento> tipos_atendimento;


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
                   String detalhes, ArrayList<Genero> publico_alvo, List especialidade,
                   int parte_corpo, int intervalo, String imagem_servico) {
        this.acao = acao;
        this.id_empresa = id_empresa;
        this.id_servico = id_servico;
        this.nome_servico = nome_servico;
        this.preco = preco;
        this.desconto = desconto;
        this.tempo_duracao = tempo_duracao;
        this.detalhes = detalhes;
        this.publico_alvo = publico_alvo;
        this.especialidade = especialidade;
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


    public List getPublico_alvo() {
        return publico_alvo;
    }

    public void setPublico_alvo(ArrayList<Genero> publico_alvo) {
        this.publico_alvo = publico_alvo;
    }

    public List getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List especialidade) {
        this.especialidade = especialidade;
    }

//    public int getParte_corpo() {
//        return parte_corpo;
//    }
//
//    public void setParte_corpo(int parte_corpo) {
//        this.parte_corpo = parte_corpo;
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

    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public int getId_parte_corpo() {
        return id_parte_corpo;
    }

    public void setId_parte_corpo(int id_parte_corpo) {
        this.id_parte_corpo = id_parte_corpo;
    }

    public String getNome_especialidade() {
        return nome_especialidade;
    }

    public void setNome_especialidade(String nome_especialidade) {
        this.nome_especialidade = nome_especialidade;
    }

//    public String getNome_parte_corpo() {
//        return nome_parte_corpo;
//    }
//
//    public void setNome_parte_corpo(String nome_parte_corpo) {
//        this.nome_parte_corpo = nome_parte_corpo;
//    }

    public int getAtivo_para_uso() {
        return ativo_para_uso;
    }

    public void setAtivo_para_uso(int ativo_para_uso) {
        this.ativo_para_uso = ativo_para_uso;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<TipoAtendimento> getTipos_atendimento() {
        return tipos_atendimento;
    }

    public void setTipos_atendimento(ArrayList<TipoAtendimento> tipos_atendimento) {
        this.tipos_atendimento = tipos_atendimento;
    }
}
