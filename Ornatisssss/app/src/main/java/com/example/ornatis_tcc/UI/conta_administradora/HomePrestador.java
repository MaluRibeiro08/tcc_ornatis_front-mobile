package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta.PrestadorConfiguracaoConta;
import com.example.ornatis_tcc.R;

public class HomePrestador extends AppCompatActivity {

    private ImageView engrenagem;
    private ImageView menu_hambuguer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_prestador);

        engrenagem = findViewById(R.id.engrenagem);
        menu_hambuguer = findViewById(R.id.menu_hambuguer);

        engrenagem.setOnClickListener(view -> {

            startActivity(new Intent(
                    HomePrestador.this,
                    PrestadorConfiguracaoConta.class
            ));
        });

        //clique para abrir menu
        menu_hambuguer.setOnClickListener(view -> {
            abrindoMenu();
        });

    }

    public void abrindoMenu(){
//        menu_hambuguer.setOnClickListener(view -> {
            if (menu_hambuguer.isClickable()){
                menu_hambuguer.setVisibility(View.VISIBLE);
            }
//        });


    }
}