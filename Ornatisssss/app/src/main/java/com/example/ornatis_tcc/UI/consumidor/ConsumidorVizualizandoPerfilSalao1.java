package com.example.ornatis_tcc.UI.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.ornatis_tcc.R;

public class ConsumidorVizualizandoPerfilSalao1 extends AppCompatActivity {


    private Button btn_fazer_agendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumidor_vizualizando_perfil_salao1);

        btn_fazer_agendamento = findViewById(R.id.btn_fazer_agendamento);

        btn_fazer_agendamento.setOnClickListener(view -> {
            startActivity(new Intent(ConsumidorVizualizandoPerfilSalao1.this, ConsumidorAgendamento.class));
        });
    }
}