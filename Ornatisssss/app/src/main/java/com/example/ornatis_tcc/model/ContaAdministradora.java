package com.example.ornatis_tcc.model;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ContaAdministradora {

    //ESTABELECIMENTO
    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

    @SerializedName("nome_fantasia")
    @Expose
    private String nome_fantasia;

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
    private Date data_nascimento;

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

    //CONFERIR O NOME, SE TA "UF" MESMO
    @SerializedName("uf")
    @Expose
    private String uf;


    //RECEBIMENTO
    @SerializedName("dados_recebimento")
    @Expose
    private ArrayList dados_recebimento;

    //REGRAS DE NEGÓCIO
    @SerializedName("dados_taxa_cancelamento")
    @Expose
    private ArrayList dados_taxa_cancelamento;

    //FUNCIONAMENTO

    @SerializedName("dados_funcionamento")
    @Expose
    private ArrayList dados_funcionamento;


    @SerializedName("intervalo_tempo_padrao_servico")
    @Expose
    private int intervalo_tempo_padrao_servico;

    @SerializedName("nome_usuario_instagram")
    @Expose
    private String nome_usuario_instagram;

    @SerializedName("link_facebook")
    @Expose
    private String link_facebook;


    //DADOS DE LOGIN
    @SerializedName("email_adm")
    @Expose
    private String email_adm;

    @SerializedName("senha_adm")
    @Expose
    private String senha_adm;

    public ContaAdministradora() {
    }


    public ContaAdministradora(int id_empresa, String nome_fantasia, String cnpj, String telefone,
                               String imagem_perfil, String biografia,
                               int id_administrador, String nome_adm, Date data_nascimento,
                               String cpf, String foto_perfil,
                               String cep, String bairro, String rua, String numero,
                               String complemento, int id_cidade, String uf, ArrayList dados_recebimento,
                               ArrayList dados_taxa_cancelamento, ArrayList dados_funcionamento,
                               int intervalo_tempo_padrao_servico, String nome_usuario_instagram,
                               String link_facebook,
                               String email_adm, String senha_adm) {
        this.id_empresa = id_empresa;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.imagem_perfil = imagem_perfil;
        this.biografia = biografia;
        this.id_administrador = id_administrador;
        this.nome_adm = nome_adm;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.foto_perfil = foto_perfil;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.id_cidade = id_cidade;
        this.uf = uf;
        this.dados_recebimento = dados_recebimento;
        this.dados_taxa_cancelamento = dados_taxa_cancelamento;
        this.dados_funcionamento = dados_funcionamento;
        this.intervalo_tempo_padrao_servico = intervalo_tempo_padrao_servico;
        this.nome_usuario_instagram = nome_usuario_instagram;
        this.link_facebook = link_facebook;
        this.email_adm = email_adm;
        this.senha_adm = senha_adm;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public ArrayList getDados_recebimento() {
        return dados_recebimento;
    }

    public void setDados_recebimento(ArrayList dados_recebimento) {
        this.dados_recebimento = dados_recebimento;
    }

    public ArrayList getDados_taxa_cancelamento() {
        return dados_taxa_cancelamento;
    }

    public void setDados_taxa_cancelamento(ArrayList dados_taxa_cancelamento) {
        this.dados_taxa_cancelamento = dados_taxa_cancelamento;
    }

    public ArrayList getDados_funcionamento() {
        return dados_funcionamento;
    }

    public void setDados_funcionamento(ArrayList dados_funcionamento) {
        this.dados_funcionamento = dados_funcionamento;
    }

    public int getIntervalo_tempo_padrao_servico() {
        return intervalo_tempo_padrao_servico;
    }

    public void setIntervalo_tempo_padrao_servico(int intervalo_tempo_padrao_servico) {
        this.intervalo_tempo_padrao_servico = intervalo_tempo_padrao_servico;
    }

    public String getNome_usuario_instagram() {
        return nome_usuario_instagram;
    }

    public void setNome_usuario_instagram(String nome_usuario_instagram) {
        this.nome_usuario_instagram = nome_usuario_instagram;
    }

    public String getLink_facebook() {
        return link_facebook;
    }

    public void setLink_facebook(String link_facebook) {
        this.link_facebook = link_facebook;
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




