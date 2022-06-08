package com.example.ornatis_tcc.UI.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ornatis_tcc.R;

public class HomeConsumidor extends AppCompatActivity {

    TextView tv_id_consumidor;
    ImageView imagem_salao1;
    ImageView imagem_salao2;
    ImageView imagem_salao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_consumidor);

//        tv_id_consumidor = findViewById(R.id.tv_id_consumidor);

//        tv_id_consumidor.setText(String.valueOf(getIntent().getExtras().getInt("id_consumidor")));

        imagem_salao1 = findViewById(R.id.imagem_salao1);
        imagem_salao2 = findViewById(R.id.imagem_salao2);
        imagem_salao3 = findViewById(R.id.imagem_salao3);


        imagem_salao1.setOnClickListener(view -> {
            startActivity(new Intent(HomeConsumidor.this, ConsumidorVizualizandoPerfilSalao1.class));
        });

        imagem_salao2.setOnClickListener(view -> {
            startActivity(new Intent(HomeConsumidor.this, ConsumidorVizualizandoPerfilSalao1.class));
        });

        imagem_salao3.setOnClickListener(view -> {
            startActivity(new Intent(HomeConsumidor.this, ConsumidorVizualizandoPerfilSalao1.class));
        });

    }
}