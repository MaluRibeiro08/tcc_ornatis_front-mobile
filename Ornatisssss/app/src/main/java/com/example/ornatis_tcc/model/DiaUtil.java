package com.example.ornatis_tcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalTime;

public class DiaUtil {

//    @SerializedName("id_dia_semana")
//    @Expose
    private float id_dia_semana;

    private LocalTime hora_inicio_localtime;

//    @SerializedName("hora_inicio")
//    @Expose
    private String hora_inicio;

    private LocalTime hora_termino_localtime;

//    @SerializedName("hora_termino")
//    @Expose
    private String hora_termino;

//    @SerializedName("dia_da_semana")
//    @Expose
    private String dia_semana;

    public DiaUtil(int id_dia_semana, LocalTime hora_inicio_localtime, LocalTime hora_termino_localtime)
    {
        this.id_dia_semana = id_dia_semana;
        this.hora_inicio_localtime = hora_inicio_localtime;
        this.hora_termino_localtime = hora_termino_localtime;

        this.hora_inicio = hora_inicio_localtime.toString();
        this.hora_termino = hora_termino_localtime.toString();
    }

    public float getId_dia_semana() {
        return id_dia_semana;
    }

    public void setId_dia_semana(float id_dia_semana) {
        this.id_dia_semana = id_dia_semana;
    }

    public LocalTime getHora_inicio_localtime() {
        return hora_inicio_localtime;
    }

    public void setHora_inicio_localtime(LocalTime hora_inicio_localtime) {
        this.hora_inicio_localtime = hora_inicio_localtime;
    }

    public LocalTime getHora_termino_localtime() {
        return hora_termino_localtime;
    }

    public void setHora_termino_localtime(LocalTime hora_termino_localtime) {
        this.hora_termino_localtime = hora_termino_localtime;
    }
}
