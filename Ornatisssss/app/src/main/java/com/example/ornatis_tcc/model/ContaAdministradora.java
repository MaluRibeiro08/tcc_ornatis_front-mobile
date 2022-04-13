package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ContaAdministradora {

    //ESTABELECIMENTO
    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

    @SerializedName("nome_fantasia")
    @Expose
    private int nome_fantasia;

    @SerializedName("cnpj")
    @Expose
    private String cnpj;

    @SerializedName("telefone")
    @Expose
    private String telefone;

    @SerializedName("imagem_perfil")
    @Expose
    private String imagem_perfil;

    @SerializedName("biografia")
    @Expose
    private String biografia;

    //ADMINISTRADOR
    @SerializedName("id_administrador")
    @Expose
    private int id_administrador;

    @SerializedName("nome_adm")
    @Expose
    private String nome_adm;

    @SerializedName("data_nascimento")
    @Expose
    private String data_nascimento;

    @SerializedName("cpf")
    @Expose
    private String cpf;

    @SerializedName("foto_perfil")
    @Expose
    private String foto_perfil;


    //LOCALIZAÇÃO
    @SerializedName("cep")
    @Expose
    private String cep;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("rua")
    @Expose
    private String rua;

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("complemento")
    @Expose
    private String complemento;

    @SerializedName("id_cidade")
    @Expose
    private int id_cidade;


//    //RECEBIMENTO
//    @SerializedName("dados_recebimento")
//    @Expose
//    private dados_recebimento;
//
//    //REGRAS DE NEGÓCIO
//    @SerializedName("dados_taxa_cancelamento")
//    @Expose
//    private dados_taxa_cancelamento;

    //FUNCIONAMENTO

    @SerializedName("dados_funcionamento")
    @Expose
    private int dados_funcionamento;

    @SerializedName("id_dia_semana")
    @Expose
    private int id_dia_semana;

    @SerializedName("data_inicio")
    @Expose
    private Date data_inicio;

    @SerializedName("data_fim_excessao")
    @Expose
    private Date data_fim_excessao;

    @SerializedName("descricao")
    @Expose
    private String descricao;


    //DADOS DE LOGIN
    @SerializedName("email_adm")
    @Expose
    private String email_adm;

    @SerializedName("senha_adm")
    @Expose
    private String senha_adm;

    public ContaAdministradora() {
    }

    public ContaAdministradora(int id_empresa){
        this.id_administrador = id_empresa;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(int nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImagem_perfil() {
        return imagem_perfil;
    }

    public void setImagem_perfil(String imagem_perfil) {
        this.imagem_perfil = imagem_perfil;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNome_adm() {
        return nome_adm;
    }

    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getDados_funcionamento() {
        return dados_funcionamento;
    }

    public void setDados_funcionamento(int dados_funcionamento) {
        this.dados_funcionamento = dados_funcionamento;
    }

    public int getId_dia_semana() {
        return id_dia_semana;
    }

    public void setId_dia_semana(int id_dia_semana) {
        this.id_dia_semana = id_dia_semana;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim_excessao() {
        return data_fim_excessao;
    }

    public void setData_fim_excessao(Date data_fim_excessao) {
        this.data_fim_excessao = data_fim_excessao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail_adm() {
        return email_adm;
    }

    public void setEmail_adm(String email_adm) {
        this.email_adm = email_adm;
    }

    public String getSenha_adm() {
        return senha_adm;
    }

    public void setSenha_adm(String senha_adm) {
        this.senha_adm = senha_adm;
    }
}
