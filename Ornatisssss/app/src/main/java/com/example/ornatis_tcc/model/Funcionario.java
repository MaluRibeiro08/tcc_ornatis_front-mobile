package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Funcionario {

    @SerializedName("acao")
    @Expose
    private String acao;

    @SerializedName("id_funcionario")
    @Expose
    private int id_funcionario;

    @SerializedName("nome_funcionario")
    @Expose
    private String nome_funcionario;

    @SerializedName("foto_perfil")
    @Expose
    private String foto_perfil;

    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

    @SerializedName("cod_funcionario")
    @Expose
    private String cod_funcionario;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("senha")
    @Expose
    private String senha;


    //CONFERIR O NOME "dados_funcionamento"
    @SerializedName("dados_dia_trabalho")
    @Expose
    private ArrayList dados_funcionamento;




    public Funcionario() {
    }

    public Funcionario(String acao, int id_funcionario, String nome_funcionario,
                       String foto_perfil, int id_empresa, String cod_funcionario,
                       String login, String senha, ArrayList dados_funcionamento) {
        this.acao = acao;
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.foto_perfil = foto_perfil;
        this.id_empresa = id_empresa;
        this.cod_funcionario = cod_funcionario;
        this.login = login;
        this.senha = senha;
        this.dados_funcionamento = dados_funcionamento;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(String cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList getDados_funcionamento() {
        return dados_funcionamento;
    }

    public void setDados_funcionamento(ArrayList dados_funcionamento) {
        this.dados_funcionamento = dados_funcionamento;
    }
}
