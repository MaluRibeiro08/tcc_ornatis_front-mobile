package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PrestadorCadastroPerfilAdministrador extends AppCompatActivity {

    private EditText et_nome_do_adm;
    private EditText et_data_nascimento;
    private EditText et_cpf;
    //  private ImageView iv_foto_perfil;??
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_perfil_administrador);

        et_nome_do_adm = findViewById(R.id.et_nome_do_adm);
        et_data_nascimento = findViewById(R.id.et_data_nascimento);
        et_cpf = findViewById(R.id.et_cpf);
        //imagem??
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);


        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroPerfilAdministrador.this,
                    PrestadorCadastroDadosLocalizacao.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroPerfilAdministrador.this,
                    PrestadorCadastroPerfilEstabelecimento.class
            ));
        }); // fim da seta voltar


    }
}