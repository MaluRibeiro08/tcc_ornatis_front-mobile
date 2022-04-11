package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PrestadorConfiguracaoConta extends AppCompatActivity {

    private TextView text_view_perfil_estabelecimento;
    private LinearLayout container_perfil_estabelecimento;

    private TextView tv_perfil_adm;
    private LinearLayout container_perfil_adm;

    private TextView tv_dados_localizacao;
    private LinearLayout containcontainer_dados_localizacaoer_perfil_adm;
         variavel divatual = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_configuracao_conta);

        text_view_perfil_estabelecimento = findViewById(R.id.text_view_perfil_estabelecimento);
        container_perfil_estabelecimento1 = findViewById(R.id.container_perfil_estabelecimento);
        container_perfil_estabelecimento2 = findViewById(R.id.container_perfil_estabelecimento);
        container_perfil_estabelecimento3 = findViewById(R.id.container_perfil_estabelecimento);

        text_view_perfil_estabelecimento.setOnClickListener(view -> {

            if(container_perfil_estabelecimento.getVisibility() == View.VISIBLE)
            {
                container_perfil_estabelecimento.setVisibility(View.GONE);
            }
            else
            {
                container_perfil_estabelecimento.setVisibility(View.VISIBLE);
            }

    //fazer uma funcao para essa parte

        });
    }

}

clivouProximo (()=>{

        mostrarDiv(divAtual+1)

        }

function mostrarDi(divPOndeQueremosIr)
        {
            container_perfil_estabelecimento${divPOndeQueremosIr}.setVisibility(View.TRUE);
            container_perfil_estabelecimento${divAtual}.setVisibility(View.GONE);
            divAtual = divPOndeQueremosIr
        }