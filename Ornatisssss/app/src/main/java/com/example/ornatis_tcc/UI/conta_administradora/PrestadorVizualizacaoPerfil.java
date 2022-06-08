package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.MainActivity;
import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorListagemFuncionarios;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.Servico;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        LinearLayout ln_link_listagem_funcionarios, ln_pai_btn_filtros;

        BottomNavigationView bottomNavigationView;

    int id_empresa =2;
    boolean servicos_carregados = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_vizualizacao_perfil);

        bottomNavigationView = findViewById(R.id.bottom_navigation_perfil_salao);

        bottomNavigationView.setSelectedItemId(R.id.menu_profile_cadastrado);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_profile_cadastrado:{
                        return true;
                    }
//                    case R.id.menu_agenda:{
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                    }
                    case R.id.menu_home_cadastrado:{
                        startActivity(new Intent(getApplicationContext(), HomePrestador.class));
                    }
                }

                return false;
            }
        });



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
                        if (servicos_carregados == false)
                        {
                            getDadosServicosEstabelecimento(id_empresa);

                            servicos_carregados = true;
                        }
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


        //VISUALIZAÇÃO DA LISTA DE FUNCIONARIOS
            ln_link_listagem_funcionarios.setOnClickListener(view ->
            {
                startActivity(new Intent(
                        PrestadorVizualizacaoPerfil.this,
                        PrestadorListagemFuncionarios.class
                ));

            });

        //BUSCAR OS DADOS E PREENCHER SECAO 'INICIO'
            getDadosPerfilEstabelecimento(id_empresa);

        //VERIFICANDO NECESSIDADE DE ABRIR ABA SERVICOS
            if (getIntent().getExtras() != null && getIntent().getExtras().getString("acao").equals("visualizar_servicos"))
            {
                trocarVisualizacaoAbas(container_servicos, tv_aba_servicos);
                if (servicos_carregados == false)
                {
                    getDadosServicosEstabelecimento(id_empresa);

                    servicos_carregados = true;
                }
            }

//        //FILTRAGEM DOS SERVICOS POR ESPECIALIDADE
//            ln_pai_btn_filtros = findViewById(R.id.ln_pai_btn_filtros);
//            int contador_filtros = 0;
//
//            while (contador_filtros < ln_pai_btn_filtros.getChildCount())
//            {
//                final int contador = contador_filtros;
//                ln_pai_btn_filtros.getChildAt(contador_filtros).setOnClickListener(
//                        view ->
//                        {
//                            filtrarServicos(ln_pai_btn_filtros.getChildAt(contador).getTag().toString())
//                        }
//                );
//
//                contador_filtros = contador_filtros+1;
//            }


    }

//    public void filtrarServicos (String tag_alvo)
//    {
//        LinearLayout pai_containers_listagem = findViewById(R.id.ln_container_geral_conteudo_listagem_perfil);
//
//        //DESAPARECENDO COM TODOS
//            int contador_container_especialidades = 0;
//            while (contador_container_especialidades < pai_containers_listagem.getChildCount())
//            {
//                pai_containers_listagem.getChildAt(contador_container_especialidades).setVisibility(View.GONE);
//
//                contador_container_especialidades = contador_container_especialidades+1;
//            }
//
//        //FAZENDO APARECER O DESEJADO
//            TextView alvo = ln_pai_btn_filtros.findViewWithTag(tag_alvo);
//            String categoria = alvo.getText().toString();
//
//            int contador_container_especialidades_2 = 0;
//            while (contador_container_especialidades_2 < pai_containers_listagem.getChildCount())
//            {
//
//                LinearLayout container_categoria = (LinearLayout) pai_containers_listagem.getChildAt(contador_container_especialidades);
//
//                container_categoria.findViewWithTag("titulo_recycler_categoria")
//                contador_container_especialidades = contador_container_especialidades_2+1;
//            }
//
//
//    }

    //BUSCA E PREENCHIMENTO ABA INICIO
        public ContaAdministradora getDadosPerfilEstabelecimento (int id_empresa)
        {
            routerInterface = APIUtil.getEmpresaInterface(); //criamos a conexAo com a API
            Call<ContaAdministradora> call = routerInterface.getDadosPerfilEstabelecimento(id_empresa); //executando a chamada para a rota

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
            boolean containerAbaixoCemVisivel = false;
            boolean containerAcimaCemVisivel = false;

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

                        if (acima_cem == 1 && containerAcimaCemVisivel== false)
                        {
                            findViewById(R.id.ln_container_geral_regras_acima_cem).setVisibility(View.VISIBLE);
                        }
                        else if (acima_cem == 0 && containerAcimaCemVisivel== false)
                        {
                            findViewById(R.id.ln_container_geral_regras_abaixo_cem).setVisibility(View.VISIBLE);
                        }

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

    //BUSCA E PREENCHIMENTO ABA SERVICOS
        public ArrayList<Servico> getDadosServicosEstabelecimento (int id_empresa)
        {
            ArrayList<Servico> arr_servicos = null;
            routerInterface = APIUtil.getEmpresaInterface(); //criamos a conexAo com a API

            Call<ArrayList<Servico>> call = routerInterface.getServicos(id_empresa); //executando a chamada para a rota de servicos

            call.enqueue(new Callback<ArrayList<Servico>>()
            {
                @Override
                public void onResponse(Call<ArrayList<Servico>> call, Response<ArrayList<Servico>> response) {
                    if (response.isSuccessful())
                    {
                        Log.d("SERVICOS-ONRESPONSE-SUCESS", String.valueOf(response.body()));

//                        List<Servico> servicos = new ArrayList<>();

                        //recebe os dados da API
                        List<Servico> list = new ArrayList<Servico>();

                        list = response.body(); //o que veio no corpo da resposta  | DADOS

                        Log.d("SERVICOS-ONRESPONSE-SUCESS", String.valueOf(list.get(0).getId_especialidade()));

                        int contador = 0;

                        Log.d("SERVICOS-ONRESPONSE-SUCESS", "list size" + String.valueOf(list.size()));

                        ArrayList<ArrayList<Servico>> arr_arr_servicos_por_especialidade = new ArrayList<ArrayList<Servico>>(Collections.nCopies(20, null));

                        while (contador < list.size())
                        {
                            Servico servico = list.get(contador);
                            int id_especialidade_servico = servico.getId_especialidade();
                                if (arr_arr_servicos_por_especialidade.get(servico.getId_especialidade()) != null)
                                {
                                    arr_arr_servicos_por_especialidade.get(servico.getId_especialidade()).add(servico);
                                }

                                else
                                {
                                    //ADICIONA AO ARRAY PAI UM ARRAY FILHO VAZIO PARA A CATEGORIA X
                                    ArrayList<Servico> arr_list_generico = new ArrayList<Servico>();
                                        arr_arr_servicos_por_especialidade.set(id_especialidade_servico,arr_list_generico);
                                        Log.d("servicos", String.valueOf(arr_arr_servicos_por_especialidade.get(id_especialidade_servico)));

                                    //ADICIONA ARRAY FILHO O SERVICO EM QUESTÃO
                                    arr_arr_servicos_por_especialidade.get(servico.getId_especialidade()).add(servico);
                                }
//                            Log.d("SERVICOS-ONRESPONSE-SUCESS", "item contador" + String.valueOf(servico));
//                            Log.d("SERVICOS-ONRESPONSE-SUCESS", "numero contador" + String.valueOf(contador));

                            contador = contador +1;
                        }
                        Log.d("servicos", String.valueOf(arr_arr_servicos_por_especialidade.get(3).get(0).getNome_especialidade()));

                        int contador_recycler = 0;
                        int id_btn_filtro = 1;
                        while (contador_recycler < arr_arr_servicos_por_especialidade.size())
                        {
                            if (arr_arr_servicos_por_especialidade.get(contador_recycler) != null)
                            {
                                ArrayList<Servico> lista_servicos_especialidade = arr_arr_servicos_por_especialidade.get(contador_recycler);

                                // PEGANDO O CONTAINER PAI E O DEIXANDO VISIVEL
                                LinearLayout ln_container_listagems = findViewById(R.id.ln_container_geral_conteudo_listagem_perfil);
                                String tag_container_listagem_servicos_categoria =  "ln_container_geral_listagem_categoria_"+ contador_recycler;
                                LinearLayout container_listagem_servicos_categoria = ln_container_listagems.findViewWithTag(tag_container_listagem_servicos_categoria);
                                container_listagem_servicos_categoria.setVisibility(View.VISIBLE);


                                //SETANDO O TITULO DA LISTAGEM
                                    String tag_tv_titulo = "titulo_recycler_categoria" + contador_recycler;
                                    TextView tv_titulo_categoria = container_listagem_servicos_categoria.findViewWithTag(tag_tv_titulo);
                                    tv_titulo_categoria.setText(lista_servicos_especialidade.get(0).getNome_especialidade());

                                //CRIANDO UM BOTÃO DE FILTRO
                                    String tag_btn_filtro = "btn_filtro_categoria" + id_btn_filtro;
                                    TextView btn_filtro = findViewById(R.id.ln_pai_btn_filtros).findViewWithTag(tag_btn_filtro);

                                    btn_filtro.setVisibility(View.VISIBLE);
                                    btn_filtro.setText(lista_servicos_especialidade.get(0).getNome_especialidade());
                                    id_btn_filtro = id_btn_filtro+1;


                                //PEGANDO O RECICLERVIEW
                                    String tag_recycler_categoria =  "recyclerViewServicosPerfilCat"+ contador_recycler;
                                    RecyclerView recyclerView = container_listagem_servicos_categoria.findViewWithTag(tag_recycler_categoria);//  RECYCLERVIEW
                                    recyclerView.setAdapter(new ServicoAdapter(lista_servicos_especialidade)); //passando os dados para a adapter

                                Log.d("servicos", String.valueOf(lista_servicos_especialidade));

                            }
                            else
                            {
                                Log.d("servicos", "NÃO tem servico para a especialidade " + contador_recycler);
                            }

                            contador_recycler = contador_recycler+1;
                        }
//                        RecyclerView recyclerView = findViewById(R.id.ln_container_geral_conteudo_listagem_perfil).findViewWithTag("recyclerViewServicosPerfilCat1");//  RECYCLERVIEW
//                        recyclerView.setAdapter(new ServicoAdapter(list)); //passando os dados para a adapter

                    }
                    else
                    {
                        Log.d("SERVICOS-ONRESPONSE-NAO-SUCESS", "deu bom não");

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Servico>> call, Throwable t)
                {
                    Log.d("SERVICOS-ON-FAILURE", t.getMessage());
                }
            });


            preencherInformacoesAbaServicos(arr_servicos);

            return arr_servicos;
        }

        public void preencherInformacoesAbaServicos (ArrayList<Servico> servicos)
        {
            Log.d("SERVICOS", String.valueOf(servicos));
        }

    //UTILS
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

        public void addTaxa(int acimaCem, int tolerancia, int taxa) {

            LinearLayout card_nova_regra = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_regra_negocio_perfil, null);
            TextView  tv_valor_taxa =  (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tv_valor_regra_cancelmento_perfil, null);
            TextView  tv_tolerancia =  (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tv_tempo_tolerancia_regra_cancelmento_perfil, null);


            tv_valor_taxa.setText(taxa + "%");
            tv_valor_taxa.setWidth(100);
            tv_tolerancia.setText(tolerancia + " h");
            tv_tolerancia.setWidth(150);

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

    private class ServicoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> // vai "abrir" o pacote de conteúdo criado pela viewholder. Ao ser criada, a ServicoAdapter procura uma viewHoolder no seu corpo
    {
        List<Servico> servicos;

        public ServicoAdapter(List<Servico> servicos)
        {
            this.servicos = servicos; //passa a response para a variavel da classe
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) //depois de passar os dados, cria a viewHolder (ela roda o construtor da classe livroViewHolder alí em baixo)
        {//renderiza
            return new ServicoAdapter.ServicoViewHolder
                    (
                            LayoutInflater.from
                                    (
                                            parent.getContext() //vai fazer um inflate a partir do pai
                                    )
                                    .inflate
                                            (
                                                    R.layout.item_container_listagem_servico,parent, false //representa o layout que será usado, diz onde vai acontecer (no pai)
                                            )
                    );//
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) //passa os dados para a viewHolder colocar nos lugares certos
        {
            Servico servico = servicos.get(position); //retorna um servico - pega o object de item e converte para servico
            ((ServicoAdapter.ServicoViewHolder) holder).setServicoData(servico); //converte a variavel holder para um ServicoAdapter.ServicoViewHolder para que chamemos o método que passa os dados dando a elas esses dados
        }

        @Override
        public int getItemCount() // controla a quantidade de servicos passados
        {
            return servicos.size();
        }


        //a classe item recebe os tipos de item que eu tenho no app. Depois que buscamos no banco, jogamos no item pra classificar.

        class ServicoViewHolder extends RecyclerView.ViewHolder//monta a estrutura em si. Junta os dados ao fragmento de layout
        {
            //atributos da classe livroviewholder - eles quem vao receber dados lá na view holder
            private TextView tv_nome_servico, tv_valor_servico;
            private LinearLayout container_ic_excluir_servico;
            private int id_servico;
            private String nome_servico;

            public ServicoViewHolder(@NonNull View itemView) //elemento gráfico - no nosso caso o itemContainerServico
            {
                super(itemView);//método construtor de viewHolder recebe o modelo de elemento gráfico que ele vai ter que construir

                tv_nome_servico = itemView.findViewById(R.id.tv_nome_do_servico);
                tv_valor_servico = itemView.findViewById(R.id.tv_valor);
                container_ic_excluir_servico = itemView.findViewById(R.id.container_ic_excluir_servico);

                //acao de click para editar servico e excluir servico
                container_ic_excluir_servico.setOnClickListener
                        (
                                view ->
                                {
                                    Log.d("SERVICO_LISTENER_CARD", "Clicou no serviço" + id_servico + " :)") ;

                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder
                                            (
                                                    PrestadorVizualizacaoPerfil.this // onde o alert dialog deve abrir
                                            )
                                            .setMessage // titulo da caixa de alerta
                                            ("Tem certeza que seja excluir o serviço " + nome_servico + "?")

                                            .setPositiveButton //define uma opcao de acao
                                            (
                                                    "Sim!",
                                                    (dialog1, witch)->
                                                    {
                                                        Log.d("SERVICO_CLICK_CARD_NEGATIVE_BTN", String.valueOf(id_servico));

                                                        routerInterface = APIUtil.getEmpresaInterface(); //abre a conexao
                                                        Call<Servico> call = routerInterface.deleteServico(id_servico); //o valor de cod veio do set livro data || Mmanda a requisicao
                                                        call.enqueue //recebendo a response surgida do call
                                                        (
                                                                new Callback<Servico>()
                                                                {
                                                                    @Override
                                                                    public void onResponse(Call<Servico> call, Response<Servico> response)
                                                                    {
                                                                        //RECARREGAR PÁGINA
                                                                            finish();
                                                                            overridePendingTransition(0, 0);
                                                                            startActivity(getIntent());
                                                                            overridePendingTransition(0, 0);
                                                                            //OU
                                                                            //recreate();

                                                                        Toast.makeText(PrestadorVizualizacaoPerfil.this, "Serviço excluido com sucesso!", Toast.LENGTH_SHORT).show();

                                                                    }

                                                                    @Override
                                                                    public void onFailure(Call<Servico> call, Throwable t)
                                                                    {
                                                                        Log.d("SERVICO_CLICK_CARD_NEGATIVE_BTN", "Oi! :)");

                                                                        Toast.makeText(PrestadorVizualizacaoPerfil.this, "Erro ao excluir servico!", Toast.LENGTH_SHORT).show();

                                                                    }
                                                                }

                                                        );
                                                    }
                                            )

                                            .setNegativeButton //define uma opcao de acao
                                            (
                                                    "Não!",
                                                    (dialog1, witch)->
                                                    {
                                                        Log.d("SERVICO_CLICK_CARD_NEGATIVE_BTN", "Olá! :)");
                                                        Toast.makeText(PrestadorVizualizacaoPerfil.this, "Exclusão cancelada!", Toast.LENGTH_SHORT).show();

                                                    }
                                            );
                                    alertDialog.show();
                                }
                        );
            }

            //metodo que carrega os dados nos elementos de view
            public void setServicoData (Servico servico)
            {
                tv_nome_servico.setText(servico.getNome_servico());
                tv_valor_servico.setText(String.valueOf(servico.getPreco()));
                id_servico = servico.getId_servico();
                nome_servico = servico.getNome_servico();
            }
        }


    }
    
}