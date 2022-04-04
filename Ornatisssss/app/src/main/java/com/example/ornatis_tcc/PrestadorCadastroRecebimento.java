package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PrestadorCadastroRecebimento extends AppCompatActivity {

    private CheckBox cb_tipo_dinheiro;
    private CheckBox cb_cartao_credito;
    private CheckBox cb_cartao_debito;
    private CheckBox cb_pix;
    private CheckBox cb_via_app;
    private EditText et_observacoes;
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_recebimento);


        cb_tipo_dinheiro = findViewById(R.id.cb_tipo_dinheiro);
        cb_cartao_credito = findViewById(R.id.cb_cartao_credito);
        cb_cartao_debito = findViewById(R.id.cb_cartao_debito);
        cb_pix = findViewById(R.id.cb_pix);
        cb_via_app = findViewById(R.id.cb_via_app);
        et_observacoes = findViewById(R.id.et_observacoes);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);

        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroRecebimento.this,
                    PrestadorCadastroRegrasNegocio.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroRecebimento.this,
                    PrestadorCadastroDadosLocalizacao.class
            ));
        }); // fim da seta voltar

    }
}