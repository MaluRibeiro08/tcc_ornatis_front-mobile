package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContaAdministradora {

//    @SerializedName("cod_livro")
//    @Expose
//    private int cod_livro;

    @SerializedName("id_empresa")
    @Expose
    private int id_empresa;

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

    //

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



}
