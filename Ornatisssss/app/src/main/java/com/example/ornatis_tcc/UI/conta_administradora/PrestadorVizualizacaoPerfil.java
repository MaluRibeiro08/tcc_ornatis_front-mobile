package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorListagemFuncionarios;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

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
        LinearLayout ln_link_listagem_funcionarios;




//PENDENCIAS
    //REGRAS DE NEGÓCIO OK
    //EVENTO PARA ABERTURA DA TELA DE LISTAGEM DE FUNCIONARIOS OK
    //NAVEGACAO ENTRE AS ABAS PRINCIPAIS (INICIO ....) (COLORIR ABINHAS)

//    ContaAdministradora contaAdministradora;
    int id_empresa =33;

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
                ln_link_listagem_funcionarios = findViewById(R.id.ln_link_listagem_funcionarios);


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
                        trocarVisualizacaoAbas(container_inicio, tv_aba_inicio);
                    }
                );
                tv_aba_servicos.setOnClickListener(view ->
                        {
                            trocarVisualizacaoAbas(container_servicos, tv_aba_servicos);
                        }
                );
                tv_aba_produtos.setOnClickListener(view ->
                        {
                            trocarVisualizacaoAbas(container_produtos, tv_aba_produtos);
                        }
                );
                tv_aba_feedback.setOnClickListener(view ->
                        {
                            trocarVisualizacaoAbas(container_feedbacks, tv_aba_feedback);
                        }
                );

        //BUSCAR OS DADOS E PREENCHER SECAO 'INICIO'
        ln_link_listagem_funcionarios.setOnClickListener(view ->
        {
            startActivity(new Intent(
                    PrestadorVizualizacaoPerfil.this,
                    PrestadorListagemFuncionarios.class
            ));

        });
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

    public void trocarVisualizacaoAbas(LinearLayout linearASerVisualizado, TextView aba_destino)
    {
        LinearLayout [] containers = new LinearLayout[] {container_inicio, container_servicos, container_produtos, container_feedbacks};
        TextView [] abas = new TextView[] {tv_aba_inicio, tv_aba_servicos, tv_aba_produtos, tv_aba_feedback};
        int contador = 0;

        while (contador < containers.length)
        {
            containers[contador].setVisibility(View.GONE);
            abas[contador].setBackgroundTintList(this.getResources().getColorStateList(R.color.white));

            contador = contador+1;
        }

        linearASerVisualizado.setVisibility(View.VISIBLE);
        aba_destino.setBackgroundTintList(this.getResources().getColorStateList(R.color.verde_claro));
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
            if (contaAdministradora.getLink_facebook() == null)
            {

                tv_facebook_salao_perfil.setText("Não cadastrado :/");
            }
            else
            {
                tv_facebook_salao_perfil.setText(contaAdministradora.getLink_facebook());
            }


        //FORMAS DE PAGAMENTO
            int contador_pagamento = 0;

            TextView observacoes_pagamento = findViewById(R.id.tv_observacoes_pagamento_perfil);
            observacoes_pagamento.setText("OBS: " + contaAdministradora.getObservacoes_pagamento());

            while (contador_pagamento < contaAdministradora.getDados_formas_pagamento().size())
            {
                String tag = "tv_forma_pagto_" + contaAdministradora.getDados_formas_pagamento().get(contador_pagamento);
                TextView txt_forma_pagamento = ln_container_formas_pagamento_perfil.findViewWithTag(tag);

                txt_forma_pagamento.setVisibility(View.VISIBLE);

                contador_pagamento= contador_pagamento+1;
            }


        //FUNCIONAMENTO
            ArrayList<ArrayList<LinkedTreeMap>> lista_dias_semama = contaAdministradora.getDados_funcionamento();

            LinearLayout linear_geral_horarios = findViewById(R.id.container_geral_dos_horarios);
            int contador_funcionamento = 0;
            boolean temAlgumHorarioVisivel = false;

            while (contador_funcionamento <= 6)
            {


                String tag = "ln_container_horarios_dia_" + String.valueOf(contador_funcionamento + 1);
                LinearLayout linear_horarios_dia_semana = linear_geral_horarios.findViewWithTag(tag);

                //Log.d("funcionamento", String.valueOf(linear_horarios_dia_semana.getChildCount()));
                if (lista_dias_semama.get(contador_funcionamento) == null)
                {
                    LinearLayout linear_pai_navegacao = findViewById(R.id.ln_container_geral_dia_semana);
                    TextView link_dia_semana = linear_pai_navegacao.findViewWithTag("tv_dia_semana_" + String.valueOf(contador_funcionamento+1));

                    link_dia_semana.setTextColor(this.getResources().getColor(R.color.cinza_padrao));
                    //Log.d("funcionamento", tag + "nao tem horario");

                }
                else
                {
                    ArrayList<LinkedTreeMap> lista_horarios_do_dia = lista_dias_semama.get(contador_funcionamento);

                    if (lista_horarios_do_dia.size() >= 1)
                    {
                        //HABILITANDO NAVEGACAO PARA ESTE DIA
                            LinearLayout linear_pai_navegacao = findViewById(R.id.ln_container_geral_dia_semana);
                            TextView link_dia_semana = linear_pai_navegacao.findViewWithTag("tv_dia_semana_" + String.valueOf(contador_funcionamento+1));

                            int finalContador_funcionamento = contador_funcionamento;

                            link_dia_semana.setOnClickListener
                            (
                                view ->
                                {
                                    mudarVisualizacaoHorarios
                                    (
                                        finalContador_funcionamento +1,
                                            linear_pai_navegacao,
                                            linear_geral_horarios
                                    );
                                }
                            );

                        //PEGANDO DADO HORA INICIO
                            String hora_inicio_inteira = String.valueOf(lista_horarios_do_dia.get(0).get("hora_inicio"));
                            String hora_inicio = hora_inicio_inteira.substring(0, hora_inicio_inteira.lastIndexOf(":"));

                        //PEGANDO DADO HORA TERMINO
                            String hora_termino_inteira = String.valueOf(lista_horarios_do_dia.get(0).get("hora_termino"));
                            String hora_termino = hora_termino_inteira.substring(0, hora_termino_inteira.lastIndexOf(":"));

                        //INSERINDO VALORES NOS TEXTVIEWS

                            //PEGANDO LINEAR PAI DOS HORARIOS
                                LinearLayout ln_container_primeiros_horarios_funcionamento = linear_horarios_dia_semana.findViewWithTag("ln_primeiros_horarios");

                            //PEGANDO OS CAMPOS DE HORARIOS DESTE PAI
                                TextView primeiro_horario_inicio = ln_container_primeiros_horarios_funcionamento.findViewWithTag("primeiro_horario_inicio");
                                TextView primeiro_horario_termino = ln_container_primeiros_horarios_funcionamento.findViewWithTag("primeiro_horario_termino");

                            //SETTANDO OS VALORES NOS SEUS RESPECTIVOS CAMPOS
                                primeiro_horario_inicio.setText(hora_inicio);
                                primeiro_horario_termino.setText(hora_termino);


                        //SETTANDO VISIBILIDADE DO PAI
                            if (temAlgumHorarioVisivel == false)
                            {
                                //DEIXANDO UM DOS HORÁRIOS VISIVEIS
                                linear_horarios_dia_semana.setVisibility(View.VISIBLE);
                                link_dia_semana.setBackgroundTintList(this.getResources().getColorStateList(R.color.cinza_horarios));

                                temAlgumHorarioVisivel = true;

                                //link_dia_semana.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
                            }

                            //Log.d("funcionamento", String.valueOf(ln_container_primeiros_horarios_funcionamento.getChildCount()));
                            //Log.d("funcionamento0", primeiro_horario_termino.getText().toString());



                    }
                    if (lista_horarios_do_dia.size() == 2)
                    {

                        //Log.d("funcionamento", "dois horarios para essse dia");
                        //HORA INICIO
                            String hora_inicio_inteira = String.valueOf(lista_horarios_do_dia.get(1).get("hora_inicio"));
                            String hora_inicio = hora_inicio_inteira.substring(0, hora_inicio_inteira.lastIndexOf(":"));

                        //HORA TERMINO
                            String hora_termino_inteira = String.valueOf(lista_horarios_do_dia.get(1).get("hora_termino"));
                            String hora_termino = hora_termino_inteira.substring(0, hora_termino_inteira.lastIndexOf(":"));

                        //INSERINDO VALORES NOS TEXTVIEWS

                            //PEGANDO LINEAR PAI DOS HORARIOS E FAZENDO-O VISIVEL
                                LinearLayout ln_container_segundos_horarios_funcionamento = linear_horarios_dia_semana.findViewWithTag("ln_segundos_horarios");
                                ln_container_segundos_horarios_funcionamento.setVisibility(View.VISIBLE);

                            //PEGANDO OS CAMPOS DE HORARIOS DESTE PAI
                                TextView primeiro_horario_inicio = ln_container_segundos_horarios_funcionamento.findViewWithTag("segundo_horario_inicio");
                                TextView primeiro_horario_termino = ln_container_segundos_horarios_funcionamento.findViewWithTag("segundo_horario_termino");

                            //SETTANDO OS VALORES NOS SEUS RESPECTIVOS CAMPOS
                                primeiro_horario_inicio.setText(hora_inicio);
                                primeiro_horario_termino.setText(hora_termino);

                        //SETTANDO VISIBILIDADE SEPARADOS
                            linear_horarios_dia_semana.findViewWithTag("simbolo_e_comercial").setVisibility(View.VISIBLE);

                        //Log.d("funcionamento", String.valueOf(ln_container_segundos_horarios_funcionamento.getChildCount()));
                        //Log.d("funcionamento0", primeiro_horario_termino.getText().toString());
                    }
                    //Log.d("funcionamento", String.valueOf(lista_dias_semama.get(contador_funcionamento)));

                }

                contador_funcionamento = contador_funcionamento+1;
            }

        //REGRAS DE NEGÓCIO
            if (contaAdministradora.getDados_taxa_cancelamento() !=null && contaAdministradora.getTaxa_unica_cancelamento() != null)
            {
                Log.d("regras_negocio", "o salao não cobra nada");
            }
            else
            {
                if (contaAdministradora.getTaxa_unica_cancelamento() != null)
                {
                    TextView tv_taxa_unica = findViewById(R.id.tv_taxa_unica_nula_perfil);
                    String texto_taxa = "Cobra-se R$ " + contaAdministradora.getTaxa_unica_cancelamento() + ",00 por cancelamento!";

                    tv_taxa_unica.setText(texto_taxa);
                    tv_taxa_unica.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_cifrao, 0, 0, 0);
                }
                else
                {
                    findViewById(R.id.ln_container_taxa_unica_nula).setVisibility(View.GONE);
                    findViewById(R.id.ln_container_geral_regras_variadas).setVisibility(View.VISIBLE);

                    int contador_regras = 0;
                    ArrayList<LinkedTreeMap> regras_cancelamento = contaAdministradora.getDados_taxa_cancelamento();

                    while (contador_regras < regras_cancelamento.size())
                    {
                        LinkedTreeMap regra = regras_cancelamento.get(contador_regras);
                        int acima_cem = Integer.parseInt(regra.get("valor_acima_de_100").toString().substring(0, regra.get("valor_acima_de_100").toString().lastIndexOf(".")));
                        int horas_tolerancia = Integer.parseInt(regra.get("horas_tolerancia").toString().substring(0, regra.get("valor_acima_de_100").toString().lastIndexOf(".")));
                        int taxa = Integer.parseInt(regra.get("porcentagem_sobre_valor_servico").toString().substring(0, regra.get("valor_acima_de_100").toString().lastIndexOf(".")));


                        Log.d("regras_negocio", String.valueOf(taxa));

                        addTaxa(
                                acima_cem,
                                horas_tolerancia,
                                taxa
                        );
                        contador_regras = contador_regras + 1;
                    }

                }
            }
        Log.d("regras_negocio", String.valueOf(contaAdministradora.getTaxa_unica_cancelamento()));



    }
    public void addTaxa(int acimaCem, int tolerancia, int taxa) {

        LinearLayout card_nova_regra = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_regra_negocio_perfil, null);
        TextView  tv_valor_taxa =  (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tv_valor_regra_cancelmento_perfil, null);
        TextView  tv_tolerancia =  (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tv_tempo_tolerancia_regra_cancelmento_perfil, null);


        tv_valor_taxa.setText(taxa + "%");
        tv_tolerancia.setText(tolerancia + " h");

        card_nova_regra.addView(tv_valor_taxa);
        card_nova_regra.addView(tv_tolerancia);

        LinearLayout container;

        if (acimaCem == 1)
        {
            container = findViewById(R.id.ln_container_regras_acima_cem);
        }
        else
        {
            container = findViewById(R.id.ln_container_regras_abaixo_cem);

        }
        container.addView(card_nova_regra);
        container.setVisibility(View.VISIBLE);
    }

    public void mudarVisualizacaoHorarios(int numero_secao_destino, LinearLayout ln_pai_tv_link_navegacao, LinearLayout ln_pai_containers_horarios)
    {
        //TIRAR O HORÁRIO QUE ESTÁ
            //TIRAR DESTAQUE DO LINK
                ArrayList<TextView> arr_links_navegacao = new ArrayList<>();
                int contadorLinks = 0;

                while (contadorLinks < ln_pai_tv_link_navegacao.getChildCount())
                {
                    arr_links_navegacao.add((TextView) ln_pai_tv_link_navegacao.getChildAt(contadorLinks));

                    Log.d("funcionamento", "io");
                    Log.d("funcionamento", String.valueOf(ln_pai_tv_link_navegacao.getChildAt(contadorLinks)));

                    contadorLinks = contadorLinks+1;
                }

                arr_links_navegacao.forEach(link -> {link.setBackgroundTintList(this.getResources().getColorStateList(R.color.white));});

              //Log.d("funcionamento", String.valueOf(arr_links_navegacao));

                //int contador_apagamento_links = 0;

                //while (contador_apagamento_links < arr_links_navegacao.size())
                //{
                    //TextView link = arr_links_navegacao.get(contador_apagamento_links);
                    //Log.d("funcionamentoa", String.valueOf(contador_apagamento_links));

                    //link.setBackgroundTintList(this.getResources().getColorStateList(R.color.white));

                    //contador_apagamento_links = contador_apagamento_links+1;
                //}

            //FECHAR CONTAINER
                ArrayList<LinearLayout> arr_container_horarios_dias_semana = new ArrayList<>();
                int contadorLineares = 0;

                while (contadorLineares < ln_pai_containers_horarios.getChildCount())
                {
                    arr_container_horarios_dias_semana.add((LinearLayout) ln_pai_containers_horarios.getChildAt(contadorLineares));
                    contadorLineares = contadorLineares+1;
                }
               arr_container_horarios_dias_semana.forEach(linearLayout -> {linearLayout.setVisibility(View.GONE);});

        //MOSTRAR O HORARIO QUE SE DESEJA
            //DESTACAR LINK
                TextView link_dia_semana = ln_pai_tv_link_navegacao.findViewWithTag("tv_dia_semana_" + numero_secao_destino);
                link_dia_semana.setBackgroundTintList(this.getResources().getColorStateList(R.color.cinza_horarios));

            //MOSTRAR CONTAINER DE HORARIOS
                String tag = "ln_container_horarios_dia_" + numero_secao_destino;
                LinearLayout linear_horarios_dia_semana = ln_pai_containers_horarios.findViewWithTag(tag);
                linear_horarios_dia_semana.setVisibility(View.VISIBLE);

        Log.d("funcionamento", "destino" + String.valueOf(numero_secao_destino));
    }
}