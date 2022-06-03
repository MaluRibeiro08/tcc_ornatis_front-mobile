package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoAtendimento
{
    @SerializedName("id_tipo_atendimento")
    @Expose
    private int id_tipo_atendimento;

    @SerializedName("nome_tipo_atendimento")
    @Expose
    private String nome_tipo_atendimento;

    public TipoAtendimento() {
    }

    public TipoAtendimento(int id_tipo_atendimento, String nome_tipo_atendimento) {
        this.id_tipo_atendimento = id_tipo_atendimento;
        this.nome_tipo_atendimento = nome_tipo_atendimento;
    }

    public int getId_tipo_atendimento() {
        return id_tipo_atendimento;
    }

    public void setId_tipo_atendimento(int id_tipo_atendimento) {
        this.id_tipo_atendimento = id_tipo_atendimento;
    }

    public String getNome_tipo_atendimento() {
        return nome_tipo_atendimento;
    }

    public void setNome_tipo_atendimento(String nome_tipo_atendimento) {
        this.nome_tipo_atendimento = nome_tipo_atendimento;
    }
}
