package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PrestadorListagemFuncionarios extends AppCompatActivity {

    private TextView adicionando_novo_funcionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_listagem_funcionarios);

        adicionando_novo_funcionario = findViewById(R.id.adicionando_novo_funcionario);

        //MUDAR DE TELA AO CLICAR NO +
//        adicionando_novo_funcionario.setOnClickListener(view -> {
//
//        });

    }
}