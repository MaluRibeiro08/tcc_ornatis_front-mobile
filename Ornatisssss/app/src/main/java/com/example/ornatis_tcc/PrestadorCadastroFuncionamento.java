package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PrestadorCadastroFuncionamento extends AppCompatActivity {

    private CheckBox cb_domingo;
    private RadioButton rb_sim;
    private RadioButton rb_nao;
    private EditText et_minutos_intervalo;
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_funcionamento);

        cb_domingo = findViewById(R.id.cb_domingo);
        rb_sim = findViewById(R.id.rb_sim);
        rb_nao = findViewById(R.id.rb_nao);
        et_minutos_intervalo = findViewById(R.id.et_minutos_intervalo);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);

        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroFuncionamento.this,
                    PrestadorDadosLogin.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroFuncionamento.this,
                    PrestadorCadastroRegrasNegocio.class
            ));
        }); // fim da seta voltar


    }
}