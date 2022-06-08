package com.example.ornatis_tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ornatis_tcc.UI.consumidor.TelaLoginConsumidor;
import com.example.ornatis_tcc.UI.conta_administradora.TelaLoginPrestador;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IdentificacaoPrestadorOuConsumidor extends AppCompatActivity {

    private CardView card_sou_prestador;
    private CardView card_sou_consumidor;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacao_prestador_ou_consumidor);

        bottomNavigationView = findViewById(R.id.bottom_navigation_sem_cadastro);
        bottomNavigationView.setSelectedItemId(R.id.menu_perfil);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_perfil:{
                        return true;
                    }
                    case R.id.menu_home:{
                        startActivity(new Intent(getApplicationContext(), HomeSemCadastroSemLogin.class));
                    }
                    case R.id.menu_pesquisar:{
                        startActivity(new Intent(getApplicationContext(), PesquisarFiltrar.class));
                    }
                }

                return false;
            }
        });

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