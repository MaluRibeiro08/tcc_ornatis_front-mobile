package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorVizualizacaoPerfil extends AppCompatActivity {

    RouterInterface routerInterface;

    //NAVEGACAO E ABAS
        TextView tv_aba_inicio;
        TextView tv_aba_servicos;
        TextView tv_aba_produtos;
        TextView tv_aba_feedback;
        LinearLayout container_inicio;
        LinearLayout container_servicos;
        LinearLayout container_produtos;
        LinearLayout container_feedbacks;

    //ABA INICIO
        TextView tv_nome_do_negocio_perfil;
        TextView tv_biografia_perfil;
        TextView tv_contato_perfil;
        TextView tv_endereco_perfil;
        TextView tv_instagram_salao_perfil;
        TextView tv_facebook_salao_perfil;
        LinearLayout ln_container_formas_pagamento_perfil;






//    ContaAdministradora contaAdministradora;
    int id_empresa =30;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_vizualizacao_perfil);

        //REFERENCIAS AOS ELEMENTOS GRAFICOS
            //ABA INICIAL
                tv_nome_do_negocio_perfil = findViewById(R.id.tv_nome_do_negocio_perfil);
                tv_biografia_perfil= findViewById(R.id.tv_biografia_perfil);
                tv_contato_perfil= findViewById(R.id.tv_contato_perfil);
                tv_endereco_perfil= findViewById(R.id.tv_endereco_perfil);
                tv_instagram_salao_perfil= findViewById(R.id.tv_instagram_salao_perfil);
                tv_facebook_salao_perfil= findViewById(R.id.tv_facebook_salao_perfil);
                ln_container_formas_pagamento_perfil = findViewById(R.id.ln_container_formas_pagamento_perfil);

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
            getDadosPerfilEstabelecimento(id_empresa);
    }

    public ContaAdministradora getDadosPerfilEstabelecimento (int id_empresa)
    {
        routerInterface = APIUtil.getEmpresaInterface(); //criamos a conexAo com a API
        Call<ContaAdministradora> call = routerInterface.getDadosPerfilEstabelecimento(id_empresa); //executando a chamada para a rota de livros

        call.enqueue(
                new Callback<ContaAdministradora>() {
                    @Override
                    public void onResponse(Call<ContaAdministradora> call, Response<ContaAdministradora> response) {
                        if (response.isSuccessful())
                        {
                            Log.d("dados_perfil", "onResponse: deu certo ");

                            ContaAdministradora conta = response.body();

                            conta = response.body();

                           preencherInformacoesAbaInicial(conta);

                            //DEBUGANDO
                                //Log.d("dados_perfil", "onResponse: infos: " + response.body().getCep());
                                //Log.d("dados_perfil", "onResponse: nome fantasia: " + conta.getNome_fantasia());
                                //Log.d("dados_perfil", "onResponse: olho o cep aí " + conta.getCep());
                                //Log.d("dados_perfil", "onResponse: olho o funcionamento aí " + conta.getDados_funcionamento().get(0));
                                //Log.d("dados_perfil", "onResponse: olha as formas de pagamento aí " + conta.getDados_formas_pagamento().get(0));
                                //Log.d("dados_perfil", "onResponse: olha as observacoes de pagamento aí " + conta.getObservacoes_pagamento());
                                //Log.d("dados_perfil", "onResponse: olha as taxas aí" + response.body().getDados_taxa_cancelamento().get(0));
                                //Log.d("dados_perfil", "onResponse: olha taxa unica aí " + conta.getTaxa_unica_cancelamento());

                        }
                    }

                    @Override
                    public void onFailure(Call<ContaAdministradora> call, Throwable t) {
                        Log.d("dados_perfil", "onFailure: deu errado: " + t.getMessage());
                    }
                }
        );

        ContaAdministradora contaAdministradora = new ContaAdministradora();

        return contaAdministradora;
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

    public void preencherInformacoesAbaInicial(ContaAdministradora contaAdministradora)
    {

        Log.d("DADOS_CONTA", "preencherInformacoesPerfilSalao: " + contaAdministradora.getNome_fantasia());

        String endereco_salao = contaAdministradora.getRua() + ", " +
                                                    contaAdministradora.getNumero_rua() + ". " +
                                                    contaAdministradora.getBairro() + ", " +
                                                    contaAdministradora.getNome_cidade() + "/" +
                                                    contaAdministradora.getSigla_estado() + ". " +
                                                    contaAdministradora.getCep() + ".";
        tv_nome_do_negocio_perfil.setText(contaAdministradora.getNome_fantasia());
        tv_biografia_perfil.setText(contaAdministradora.getBiografia());
        tv_contato_perfil.setText(contaAdministradora.getTelefone());
        tv_endereco_perfil.setText(endereco_salao);

        //REDES SOCIAIS
            if (contaAdministradora.getNome_usuario_instagram() == null)
            {

                tv_instagram_salao_perfil.setText("Não cadastrado :/");
            }
            else
            {
                tv_instagram_salao_perfil.setText(contaAdministradora.getNome_usuario_instagram());
            }
            if (contaAdministradora.getNome_usuario_instagram() == null)
            {

                tv_facebook_salao_perfil.setText("Não cadastrado :/");
            }
            else
            {
                tv_facebook_salao_perfil.setText(contaAdministradora.getLink_facebook());
            }


        //FORMAS DE PAGAMENTO
            int contador = 0;

            while (contador < contaAdministradora.getDados_formas_pagamento().size())
            {
                String tag = "tv_forma_pagto_" + contaAdministradora.getDados_formas_pagamento().get(contador);
                TextView txt_forma_pagamento = ln_container_formas_pagamento_perfil.findViewWithTag(tag);

                txt_forma_pagamento.setVisibility(View.VISIBLE);

                contador= contador+1;
            }


        //FUNCIONAMENTO
            //pegar os lineares pelo id container_geral_dos_horarios
            //pegar os elementos pelo tag

        //OBSERVACOES DE PAGAMENTO
        //REGRAS DE NEGÓCIO



    }
}