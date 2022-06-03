package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genero
{
    @SerializedName("id_genero")
    @Expose
    private int id_genero;

    @SerializedName("nome_genero")
    @Expose
    private String nome_genero;


    public Genero() {
    }

    public Genero(int id_genero, String nome_genero) {
        this.id_genero = id_genero;
        this.nome_genero = nome_genero;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
}
