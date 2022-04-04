package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PrestadorDadosLogin extends AppCompatActivity {

    private EditText et_email;
    private EditText et_senha;
    private EditText et_confirmar_senha;
    private Button btn_cadastrar;
    private TextView arrow_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_dados_login);

        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);
        et_confirmar_senha = findViewById(R.id.et_confirmar_senha);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        arrow_back = findViewById(R.id.arrow_back);

        btn_cadastrar.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorDadosLogin.this,
                    HomePrestador.class
            ));
        }); // fim da seta avançar

        arrow_back.setOnClickListener(view -> {

            startActivity(new Intent(
                    PrestadorDadosLogin.this,
                    PrestadorCadastroFuncionamento.class

            ));
        }); // fim da seta voltar
    } //OnCreate

    /** MÉTODO DE VALIDAÇÃO **/
//    private boolean validate(){
//        return(
//                !et_email.getText().toString().isEmpty() &&
//                        !et_senha.getText().toString().isEmpty() &&
//                        !et_confirmar_senha.getText().toString().isEmpty()
//        );
//    }
}