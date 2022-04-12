package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Teste2 extends AppCompatActivity {

    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;
    private LinearLayout container5;
    private LinearLayout container6;
    private LinearLayout container7;
    private TextView arrow_back;
    private TextView arrow_forward;

    int numeroContainerAtual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);

        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);
        container4 = findViewById(R.id.container4);
        container5 = findViewById(R.id.container5);
        container6 = findViewById(R.id.container6);
        container7 = findViewById(R.id.container7);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);

        arrow_forward.setOnClickListener(view -> {
            int numeroContainerDestino = numeroContainerAtual+1;
            numeroContainerAtual = numeroContainerAtual+1;
            mostrarContainerDestino(numeroContainerDestino);
        });

        arrow_back.setOnClickListener(view -> {
            int numeroContainerAnterior = numeroContainerAtual-1;
            numeroContainerAtual = numeroContainerAtual-1;
            mostrarContainerAnterior(numeroContainerAnterior);
        });

    }

    //IR PARA A PRÓXIMA TELA
    private void mostrarContainerDestino(int numeroContainerDestino ) {

        LinearLayout containerDestino = null;
        LinearLayout containerAtual = null;

        if(numeroContainerDestino == 2) {
            containerDestino = container2;
            containerAtual = container1;
        }

        else if(numeroContainerDestino == 3) {
            containerDestino = container3;
            containerAtual = container2;
        }

        else if(numeroContainerDestino == 4) {
            containerDestino = container4;
            containerAtual = container3;
        }

        else if(numeroContainerDestino == 5) {
            containerDestino = container5;
            containerAtual = container4;
        }

        else if(numeroContainerDestino == 6) {
            containerDestino = container6;
            containerAtual = container5;
        }

        else {
            containerAtual = container6;
        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }


    //VOLTAR PARA A "TELA" ANTERIOR
    private void mostrarContainerAnterior(int numeroContainerDestino) {
        LinearLayout containerDestino = null;
        LinearLayout containerAtual = null;

        if(numeroContainerDestino == 1) {
            containerDestino = container1;
            containerAtual = container2;
        }

        else if(numeroContainerDestino == 2) {
            containerDestino = container2;
            containerAtual = container3;
        }

        else if(numeroContainerDestino == 3) {
            containerDestino = container3;
            containerAtual = container4;
        }

        else if(numeroContainerDestino == 4) {
            containerDestino = container4;
            containerAtual = container5;
        }

        else if(numeroContainerDestino == 5) {
            containerDestino = container5;
            containerAtual = container6;
        }

        else if(numeroContainerDestino == 6) {
            containerDestino = container6;
            containerAtual = container7;
        }

        else {
            containerDestino = container7;
            containerAtual = container1;
        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }

}
