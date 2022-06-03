package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ornatis_tcc.UI.consumidor.TelaLoginConsumidor;
import com.example.ornatis_tcc.UI.conta_administradora.TelaLoginPrestador;

public class IdentificacaoPrestadorOuConsumidor extends AppCompatActivity {

    private CardView card_sou_prestador;
    private CardView card_sou_consumidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacao_prestador_ou_consumidor);

        card_sou_prestador = findViewById(R.id.card_sou_prestador);
        card_sou_consumidor = findViewById(R.id.card_sou_consumidor);


        card_sou_prestador.setOnClickListener(view -> {
            startActivity(new Intent(IdentificacaoPrestadorOuConsumidor.this, TelaLoginPrestador.class));
        });

        card_sou_consumidor.setOnClickListener(view -> {
            startActivity(new Intent(IdentificacaoPrestadorOuConsumidor.this, TelaLoginConsumidor.class));
        });

    }
}