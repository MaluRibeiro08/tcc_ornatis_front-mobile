package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ornatis_tcc.R;

import java.util.ArrayList;

public class PrestadorVizualizacaoPerfil extends AppCompatActivity {

    TextView tv_aba_inicio;
    TextView tv_aba_servicos;
    TextView tv_aba_produtos;
    TextView tv_aba_feedback;
    LinearLayout container_inicio;
    LinearLayout container_servicos;
    LinearLayout container_produtos;
    LinearLayout container_feedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_vizualizacao_perfil);

        //NAVEGAÇÃO ENTRE AS SECOES
            //ATRIBUINDO OS ELEMENTOS GRÁFICOS À VARIAVEL
                tv_aba_inicio = findViewById(R.id.tv_aba_inicio_adm);
                tv_aba_servicos = findViewById(R.id.tv_aba_servicos_adm);
                tv_aba_produtos = findViewById(R.id.tv_aba_produtos_adm);
                tv_aba_feedback = findViewById(R.id.tv_aba_feedback_adm);

                container_inicio = findViewById(R.id.linear_container_aba_inicio_adm);
                container_servicos = findViewById(R.id.linear_container_aba_servicos_adm);
                container_produtos = findViewById(R.id.linear_container_aba_produtos_adm);
                container_feedbacks = findViewById(R.id.linear_container_aba_feedbacks_adm);


            //EVENTOS DE CLICK E NAVEGACAO
            tv_aba_inicio.setOnClickListener(view ->
                {
                    trocarVisualizacaoAbas(container_inicio);
                }
            );
            tv_aba_servicos.setOnClickListener(view ->
                    {
                        trocarVisualizacaoAbas(container_servicos);
                    }
            );
            tv_aba_produtos.setOnClickListener(view ->
                    {
                        trocarVisualizacaoAbas(container_produtos);
                    }
            );
            tv_aba_feedback.setOnClickListener(view ->
                    {
                        trocarVisualizacaoAbas(container_feedbacks);
                    }
            );
        //BUSCAR OS DADOS E PREENCHER SECAO 'INICIO'


    }

    public void trocarVisualizacaoAbas(LinearLayout linearASerVisualizado)
    {
        LinearLayout [] containers = new LinearLayout[] {container_inicio, container_servicos, container_produtos, container_feedbacks};
        int contador = 0;

        while (contador < containers.length)
        {
            containers[contador].setVisibility(View.GONE);
            contador = contador+1;
        }

        linearASerVisualizado.setVisibility(View.VISIBLE);
    }
}