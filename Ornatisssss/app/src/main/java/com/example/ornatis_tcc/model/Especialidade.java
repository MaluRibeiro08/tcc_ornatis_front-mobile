package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Especialidade
{
    @SerializedName("id_especialidade")
    @Expose
    private int id_especialidade;

    @SerializedName("nome_especialidade")
    @Expose
    private String nome_especialidade;

    public Especialidade() {
    }

    public Especialidade(int id_especialidade, String nome_especialidade) {
        this.id_especialidade = id_especialidade;
        this.nome_especialidade = nome_especialidade;
    }

    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public String getNome_especialidade() {
        return nome_especialidade;
    }

    public void setNome_especialidade(String nome_especialidade) {
        this.nome_especialidade = nome_especialidade;
    }
}
