package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.concurrent.TimeoutException;

public class ContaAdministradora {

//    @SerializedName("cod_livro")
//    @Expose
//    private int cod_livro;

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
//    @SerializedName("id_administrador")
//    @Expose
//    private String id_administrador;

    @SerializedName("nome_adm")
    @Expose
    private String nome_adm;

    @SerializedName("data_nascimento")
    @Expose
    private String data_nascimento;

    @SerializedName("cpf")
    @Expose
    private String cpf;

    //foto do adm seria a do funcionario?
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



    //o que fazer com chaves estrangeiras?

    @SerializedName("cidade")
    @Expose
    private String cidade;

    @SerializedName("uf")
    @Expose
    private String uf;


    //RECEBIMENTO
    //e quando é check box ou radio button?

    //REGRAS DE NEGÓCIO

    //FUNCIONAMENTO

    //O QUE FAZER QUANDO É TIME??
            //    @SerializedName("data_inicio")
            //    @Expose
            //    private TIME data_inicio;

            //    @SerializedName("data_fim_excessao")
            //    @Expose
            //    private String data_fim_excessao;
            //
            //    @SerializedName("descricao")
            //    @Expose
            //    private String descricao;


    //DADOS DE LOGIN


    public ContaAdministradora() {
    }

//    public ContaAdministradora(int id_empresa, ){
//
//    }

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

//    public String getData_fim_excessao() {
//        return data_fim_excessao;
//    }
//
//    public void setData_fim_excessao(String data_fim_excessao) {
//        this.data_fim_excessao = data_fim_excessao;
//    }
}
