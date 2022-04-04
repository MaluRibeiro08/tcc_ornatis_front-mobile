package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class PrestadorCadastroDadosLocalizacao extends AppCompatActivity {

    private EditText et_cep;
    private EditText et_bairro;
    private EditText et_rua;
    private EditText et_numero;
    private EditText et_complemento;
    private EditText et_cidade;
    private EditText et_uf;
    private TextView arrow_back;
    private TextView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastro_dados_localizacao);

        et_cep = findViewById(R.id.et_cep);
        et_bairro = findViewById(R.id.et_bairro);
        et_rua = findViewById(R.id.et_rua);
        et_numero = findViewById(R.id.et_numero);
        et_complemento = findViewById(R.id.et_complemento);
        et_cidade = findViewById(R.id.et_cidade);
        et_uf = findViewById(R.id.et_uf);
        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);


        arrow_forward.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroDadosLocalizacao.this,
                    PrestadorCadastroRecebimento.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorCadastroDadosLocalizacao.this,
                    PrestadorCadastroPerfilAdministrador.class
            ));
        }); // fim da seta voltar


    } //OnCreate



//    /** INFLATE DO MENU **/
//    //novo método, fora do onCreate
//
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu, menu);
//
//        return super.onCreateOptionsMenu(menu);
//        //operador super - acessar algo (um atrubuto, metodo)
//        // mas isso pertence a classe mãe AppCompatActivity
//    }



}