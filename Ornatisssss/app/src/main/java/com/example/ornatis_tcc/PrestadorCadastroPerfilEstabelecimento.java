package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PrestadorCadastroPerfilEstabelecimento extends AppCompatActivity {

    private EditText et_nome_do_negocio;
    private EditText et_cnpj;
    private EditText et_contato;
//  private ImageView iv_foto_perfil;
    private EditText et_biografia;
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_perfil_estabelecimento);

        et_nome_do_negocio = findViewById(R.id.et_nome_do_negocio);
        et_cnpj = findViewById(R.id.et_cnpj);
        et_contato = findViewById(R.id.et_contato);
        //imagem
        et_biografia = findViewById(R.id.et_biografia);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);


        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroPerfilEstabelecimento.this,
                    PrestadorCadastroPerfilAdministrador.class
            ));
        }); // fim da seta avançar


//        arrow_back.setOnClickListener(view -> {
//
//            startActivity(new Intent(
//                    PrestadorCadastroPerfilEstabelecimento.this,
//                    .class
//            ));
//        }); // fim da seta avançar




    }
}