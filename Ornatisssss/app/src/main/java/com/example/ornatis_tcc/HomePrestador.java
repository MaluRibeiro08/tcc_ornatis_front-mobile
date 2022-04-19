package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomePrestador extends AppCompatActivity {

    private TextView engrenagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_prestador);

        engrenagem = findViewById(R.id.engrenagem);

        engrenagem.setOnClickListener(view -> {

            startActivity(new Intent(
                    HomePrestador.this,
                    PrestadorConfiguracaoConta.class
            ));
        });

    }
}