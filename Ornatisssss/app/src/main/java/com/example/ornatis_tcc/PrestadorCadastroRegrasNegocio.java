package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PrestadorCadastroRegrasNegocio extends AppCompatActivity {

    private RadioButton rb_cancelamento_sim;
    private RadioButton rb_cancelamento_nao;
    private RadioButton rb_taxa_unica;
    private EditText et_taxa_unica;
    private RadioButton rb_personalizada;
    private RadioButton rb_abaixo_cem;
    private RadioButton rb_acima_cem;
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_regras_negocio);

        rb_cancelamento_sim = findViewById(R.id.rb_cancelamento_sim);
        rb_cancelamento_nao = findViewById(R.id.rb_cancelamento_nao);
        rb_taxa_unica = findViewById(R.id.rb_taxa_unica);
        et_taxa_unica = findViewById(R.id.et_taxa_unica);
        rb_personalizada = findViewById(R.id.rb_personalizada);
        rb_abaixo_cem = findViewById(R.id.rb_abaixo_cem);
        rb_acima_cem = findViewById(R.id.rb_acima_cem);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);


        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroRegrasNegocio.this,
                    PrestadorCadastroFuncionamento.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroRegrasNegocio.this,
                    PrestadorCadastroRecebimento.class
            ));
        }); // fim da seta voltar

    }
}