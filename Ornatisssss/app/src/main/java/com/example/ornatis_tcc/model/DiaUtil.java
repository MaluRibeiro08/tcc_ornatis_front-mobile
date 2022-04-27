package com.example.ornatis_tcc.model;

import java.time.LocalTime;

public class DiaUtil {
    private int id_dia_semana;
    private LocalTime hora_inicio;
    private LocalTime hora_termino;

    public DiaUtil(int id_dia_semana, LocalTime hora_inicio, LocalTime hora_termino)
    {
        this.id_dia_semana = id_dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_termino = hora_termino;
    }

    public int getId_dia_semana() {
        return id_dia_semana;
    }

    public void setId_dia_semana(int id_dia_semana) {
        this.id_dia_semana = id_dia_semana;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(LocalTime hora_termino) {
        this.hora_termino = hora_termino;
    }
}
