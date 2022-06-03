package com.example.ornatis_tcc.UI.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.consumidor.manutencao_conta.CadastroConsumidor;
import com.example.ornatis_tcc.UI.conta_administradora.HomePrestador;
import com.example.ornatis_tcc.UI.conta_administradora.TelaLoginPrestador;
import com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta.CadastroContaAdministradora;

public class TelaLoginConsumidor extends AppCompatActivity {

    private EditText et_login_consumidor;
    private EditText et_senha_consumidor;
    private TextView esqueci_senha_consumidor;
    private TextView nao_tem_cadastro_consumidor;
    private Button btn_fazer_login_consumidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_consumidor);

        et_login_consumidor = findViewById(R.id.et_login_consumidor);
        et_senha_consumidor = findViewById(R.id.et_senha_consumidor);
        esqueci_senha_consumidor = findViewById(R.id.esqueci_senha_consumidor);
        nao_tem_cadastro_consumidor = findViewById(R.id.nao_tem_cadastro_consumidor);
        btn_fazer_login_consumidor = findViewById(R.id.btn_fazer_login_consumidor);

//        nao_tem_cadastro_consumidor.setOnClickListener(view -> {
//            startActivity(new Intent(TelaLoginConsumidor.this, CadastroConsumidor.class));
//        });
//
//        btn_fazer_login_consumidor.setOnClickListener(view -> {
//            startActivity(new Intent(TelaLoginConsumidor.this, HomeConsumidor.class));
//        });

    }
}