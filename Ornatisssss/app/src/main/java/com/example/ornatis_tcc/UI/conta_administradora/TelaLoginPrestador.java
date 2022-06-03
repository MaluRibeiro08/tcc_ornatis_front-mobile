package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta.CadastroContaAdministradora;

public class TelaLoginPrestador extends AppCompatActivity {

    private EditText et_login_prestador;
    private EditText et_senha_prestador;
    private TextView esqueci_senha_prestador;
    private TextView nao_tem_cadastro_prestador;
    private Button btn_fazer_login_prestador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_prestador);

        et_login_prestador = findViewById(R.id.et_login_prestador);
        et_senha_prestador = findViewById(R.id.et_senha_prestador);
        esqueci_senha_prestador = findViewById(R.id.esqueci_senha_prestador);
        nao_tem_cadastro_prestador = findViewById(R.id.nao_tem_cadastro_prestador);
        btn_fazer_login_prestador = findViewById(R.id.btn_fazer_login_prestador);


        nao_tem_cadastro_prestador.setOnClickListener(view -> {
            startActivity(new Intent(TelaLoginPrestador.this, CadastroContaAdministradora.class));


            /**** ALERT DIOLOG***/
//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(TelaLoginPrestador.this)
//                    .setMessage("Você será redirecionado(a) para realizar o seu cadastro")
//                    .setPositiveButton("Ok", (dialog, witch)-> {
//                        Intent intent = new Intent(TelaLoginPrestador.this, CadastroContaAdministradora.class);
//                        startActivity(intent);
//                    })
//                    .setNegativeButton("Cancelar", (dialog, witch)->{});
        });

        btn_fazer_login_prestador.setOnClickListener(view -> {
            startActivity(new Intent(TelaLoginPrestador.this, HomePrestador.class));
        });

    }
}