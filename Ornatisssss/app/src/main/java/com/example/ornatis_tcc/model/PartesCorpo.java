package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartesCorpo
{
    @SerializedName("id_parte_corpo")
    @Expose
    private int id_parte_corpo;

    @SerializedName("nome_parte_corpo")
    @Expose
    private String nome_parte_corpo;

    public PartesCorpo() {
    }

    public PartesCorpo(int id_parte_corpo, String nome_parte_corpo) {
        this.id_parte_corpo = id_parte_corpo;
        this.nome_parte_corpo = nome_parte_corpo;
    }

    public int getId_parte_corpo() {
        return id_parte_corpo;
    }

    public void setId_parte_corpo(int id_parte_corpo) {
        this.id_parte_corpo = id_parte_corpo;
    }

    public String getNome_parte_corpo() {
        return nome_parte_corpo;
    }

    public void setNome_parte_corpo(String nome_parte_corpo) {
        this.nome_parte_corpo = nome_parte_corpo;
    }
}
