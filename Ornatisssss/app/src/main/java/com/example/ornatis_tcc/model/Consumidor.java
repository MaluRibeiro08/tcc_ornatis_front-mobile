package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consumidor
{
    @SerializedName("acao")
    @Expose
    private String acao;

    @SerializedName("id_consumidor")
    @Expose
    private int id_consumidor;

    @SerializedName("nome_consumidor")
    @Expose
    private String nome_consumidor;

    @SerializedName("data_nascimento")
    @Expose
    private String data_nascimento_consumidor;

    private LocalDate data_nascimento_type_date;

    @SerializedName("cpf_consumidor")
    @Expose
    private String cpf_consumidor;

    @SerializedName("telefone")
    @Expose
    private String telefone_consumidor;

    @SerializedName("id_genero")
    @Expose
    private int genero_consumidor;

    @SerializedName("id_cor_cabelo")
    @Expose
    private Integer id_cor_cabelo;

    @SerializedName("id_tipo_cabelo")
    @Expose
    private Integer id_tipo_cabelo;

    @SerializedName("id_comprimento_cabelo")
    @Expose
    private Integer id_comprimento_cabelo;

    @SerializedName("email_consumidor")
    @Expose
    private String email_consumidor;

    @SerializedName("senha_consumidor")
    @Expose
    private String senha_consumidor;


    @SerializedName("bairro")
    @Expose
    private String bairro_consumidor;


    @SerializedName("rua")
    @Expose
    private String rua_consumidor;


    @SerializedName("numero")
    @Expose
    private String numero_endereco_consumidor;

    @SerializedName("cep")
    @Expose
    private String cep_endereco_consumidor;

    @SerializedName("complemento")
    @Expose
    private String complemento_endereco_consumidor;

    @SerializedName("id_cidade")
    @Expose
    private String id_cidade;


    public Consumidor() {
    }

    public Consumidor(String acao, String nome_consumidor, String data_nascimento_consumidor, LocalDate data_nascimento_type_date, String cpf_consumidor, String telefone_consumidor, int genero_consumidor, int id_cor_cabelo, int id_tipo_cabelo, int id_comprimento_cabelo, String email_consumidor, String senha_consumidor, String bairro_consumidor, String rua_consumidor, String numero_endereco_consumidor, String cep_endereco_consumidor, String complemento_endereco_consumidor, String id_cidade) {
        this.acao = acao;
        this.nome_consumidor = nome_consumidor;
        this.data_nascimento_consumidor = data_nascimento_consumidor;
        this.data_nascimento_type_date = data_nascimento_type_date;
        this.cpf_consumidor = cpf_consumidor;
        this.telefone_consumidor = telefone_consumidor;
        this.genero_consumidor = genero_consumidor;
        this.id_cor_cabelo = id_cor_cabelo;
        this.id_tipo_cabelo = id_tipo_cabelo;
        this.id_comprimento_cabelo = id_comprimento_cabelo;
        this.email_consumidor = email_consumidor;
        this.senha_consumidor = senha_consumidor;
        this.bairro_consumidor = bairro_consumidor;
        this.rua_consumidor = rua_consumidor;
        this.numero_endereco_consumidor = numero_endereco_consumidor;
        this.cep_endereco_consumidor = cep_endereco_consumidor;
        this.complemento_endereco_consumidor = complemento_endereco_consumidor;
        this.id_cidade = id_cidade;
    }

    public String getAcao() {
        return acao;
    }


    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getNome_consumidor() {
        return nome_consumidor;
    }

    public void setNome_consumidor(String nome_consumidor) {
        this.nome_consumidor = nome_consumidor;
    }

    public String getData_nascimento_consumidor() {
        return data_nascimento_consumidor;
    }

    public void setData_nascimento_consumidor(LocalDate data_nascimento_localDate) {
        this.data_nascimento_type_date = data_nascimento_localDate;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        data_nascimento_consumidor = this.data_nascimento_type_date.format(formatter);
    }

    public String getCpf_consumidor() {
        return cpf_consumidor;
    }

    public void setCpf_consumidor(String cpf_consumidor) {
        this.cpf_consumidor = cpf_consumidor;
    }

    public String getTelefone_consumidor() {
        return telefone_consumidor;
    }

    public void setTelefone_consumidor(String telefone_consumidor) {
        this.telefone_consumidor = telefone_consumidor;
    }

    public int getGenero_consumidor() {
        return genero_consumidor;
    }

    public void setGenero_consumidor(int genero_consumidor) {
        this.genero_consumidor = genero_consumidor;
    }

    public Integer getId_cor_cabelo() {
        return id_cor_cabelo;
    }

    public void setId_cor_cabelo(Integer id_cor_cabelo) {
        this.id_cor_cabelo = id_cor_cabelo;
    }

    public Integer getId_tipo_cabelo() {
        return id_tipo_cabelo;
    }

    public void setId_tipo_cabelo(Integer id_tipo_cabelo) {
        this.id_tipo_cabelo = id_tipo_cabelo;
    }

    public Integer getId_comprimento_cabelo() {
        return id_comprimento_cabelo;
    }

    public void setId_comprimento_cabelo(Integer id_comprimento_cabelo) {
        this.id_comprimento_cabelo = id_comprimento_cabelo;
    }

    public String getEmail_consumidor() {
        return email_consumidor;
    }

    public void setEmail_consumidor(String email_consumidor) {
        this.email_consumidor = email_consumidor;
    }

    public String getSenha_consumidor() {
        return senha_consumidor;
    }

    public void setSenha_consumidor(String senha_consumidor) {
        this.senha_consumidor = senha_consumidor;
    }

    public String getBairro_consumidor() {
        return bairro_consumidor;
    }

    public void setBairro_consumidor(String bairro_consumidor) {
        this.bairro_consumidor = bairro_consumidor;
    }

    public String getRua_consumidor() {
        return rua_consumidor;
    }

    public void setRua_consumidor(String rua_consumidor) {
        this.rua_consumidor = rua_consumidor;
    }

    public String getNumero_endereco_consumidor() {
        return numero_endereco_consumidor;
    }

    public void setNumero_endereco_consumidor(String numero_endereco_consumidor) {
        this.numero_endereco_consumidor = numero_endereco_consumidor;
    }

    public String getCep_endereco_consumidor() {
        return cep_endereco_consumidor;
    }

    public void setCep_endereco_consumidor(String cep_endereco_consumidor) {
        this.cep_endereco_consumidor = cep_endereco_consumidor;
    }

    public String getComplemento_endereco_consumidor() {
        return complemento_endereco_consumidor;
    }

    public void setComplemento_endereco_consumidor(String complemento_endereco_consumidor) {
        this.complemento_endereco_consumidor = complemento_endereco_consumidor;
    }

    public String getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(String id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getId_consumidor() {
        return id_consumidor;
    }

    public void setId_consumidor(int id_consumidor) {
        this.id_consumidor = id_consumidor;
    }
}
