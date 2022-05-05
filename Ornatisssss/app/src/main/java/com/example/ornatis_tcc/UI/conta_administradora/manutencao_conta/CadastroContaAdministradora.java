package com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.DiaUtil;
import com.example.ornatis_tcc.model.RegraCancelamento;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroContaAdministradora extends AppCompatActivity {

    RouterInterface routerInterface;

    private int id_empresa = 1;
    private String id_cidade = "3510609";
    private ImageView menu_hambuguer;
    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;
    private LinearLayout container5;
    private LinearLayout container6;
    private LinearLayout linear_intervalo_padrao;
    private LinearLayout container7;
    private TextView arrow_back;
    private TextView arrow_forward;
    private LinearLayout linear_cb_dia_semana;
    private LinearLayout linear_horarios;
    //
    private Button btn_cadastrar;

    private RadioGroup radio_group_sim_ou_nao;
    private RadioButton rb_cancelamento_sim;
    private RadioButton rb_cancelamento_nao;
    private RadioButton rb_taxa_unica;
    private RadioButton rb_personalizada;
    private ImageButton adicionar_novo_conteiner_taxa_personalizada;
    private LinearLayout conteiner_radiobutton_sim;
    private LinearLayout linear_taxa_personalizada;

    int numeroContainerAtual = 1;
    int numero_regra_geral = 2;

    private EditText et_taxa_unica;

    //estabelecimento
    EditText et_nome_do_negocio;
    EditText et_cnpj;
    EditText et_contato;
    ImageView iv_foto_perfil_estabelecimento;
    EditText et_biografia;

    //adm
    EditText et_nome_do_adm;
    EditText et_data_nascimento;
    EditText et_cpf;
    ImageView iv_foto_perfil_adm;

    //localizacao
    EditText et_cep;
    EditText et_bairro;
    EditText et_rua;
    EditText et_numero;
    EditText et_complemento;
    EditText et_cidade;
    EditText et_uf;

    //recebimento
    CheckBox cb_tipo_dinheiro;
    CheckBox cb_cartao_credito;
    CheckBox cb_cartao_debito;
    CheckBox cb_pix;
    CheckBox cb_via_app;
    EditText et_observacoes;

    //regras de negócio
//    RadioButton rb_cancelamento_sim;
//    RadioButton rb_cancelamento_nao;
//    RadioButton rb_taxa_unica;
//    RadioButton rb_personalizada;
    RadioButton rb_sim_intervalo_padrao_servicos;
    RadioButton rb_nao_intervalo_padrao_servicos;

    //funcionamento
//    CheckBox cb_domingo;
//    CheckBox cb_segunda;
//    CheckBox cb_terca;
//    CheckBox cb_quarta;
//    CheckBox cb_quinta;
//    CheckBox cb_sexta;
//    CheckBox cb_sabado;

    //dados de login
    EditText et_email;
    EditText et_senha;
    EditText et_confirmar_senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_conta_administradora);

        et_taxa_unica = findViewById(R.id.et_taxa_unica);

        menu_hambuguer = findViewById(R.id.menu_hambuguer);
        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);
        container4 = findViewById(R.id.container4);
        container5 = findViewById(R.id.container5);
        container6 = findViewById(R.id.container6);
        container7 = findViewById(R.id.container7);
        linear_intervalo_padrao = findViewById(R.id.linear_intervalo_padrao);
        linear_cb_dia_semana = findViewById(R.id.linear_cb_dia_semana);
        linear_horarios = findViewById(R.id.linear_horarios);

        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        radio_group_sim_ou_nao = findViewById(R.id.radio_group_sim_ou_nao);
        rb_cancelamento_sim = findViewById(R.id.rb_cancelamento_sim);
        rb_cancelamento_nao = findViewById(R.id.rb_cancelamento_nao);
        rb_taxa_unica = findViewById(R.id.rb_taxa_unica);
        rb_personalizada = findViewById(R.id.rb_personalizada);

        rb_sim_intervalo_padrao_servicos = findViewById(R.id.rb_sim_intervalo_padrao_servicos);
        rb_nao_intervalo_padrao_servicos = findViewById(R.id.rb_nao_intervalo_padrao_servicos);

        adicionar_novo_conteiner_taxa_personalizada = findViewById(R.id.adicionar_novo_conteiner_taxa_personalizada);
        conteiner_radiobutton_sim = findViewById(R.id.conteiner_radiobutton_sim);
        linear_taxa_personalizada = findViewById(R.id.linear_taxa_personalizada);


        //ATRELAMENTO DA REPRESENTAÇÃO COM O COMPONENETE GRÁFICO
        //estabelecimento
        et_nome_do_negocio = findViewById(R.id.et_nome_do_negocio);
        et_cnpj = findViewById(R.id.et_cnpj);
        et_contato = findViewById(R.id.et_contato);
        et_biografia = findViewById(R.id.et_biografia);

        et_nome_do_adm = findViewById(R.id.et_nome_do_adm);
        et_data_nascimento = findViewById(R.id.et_data_nascimento);
        et_cpf = findViewById(R.id.et_cpf);
        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);

        et_cep = findViewById(R.id.et_cep);
        et_bairro = findViewById(R.id.et_bairro);
        et_rua = findViewById(R.id.et_rua);
        et_numero = findViewById(R.id.et_numero);
        et_complemento = findViewById(R.id.et_complemento);
        et_cidade = findViewById(R.id.et_cidade);
        et_uf = findViewById(R.id.et_uf);

//        cb_tipo_dinheiro = findViewById(R.id.cb_tipo_dinheiro);
//        cb_cartao_credito = findViewById(R.id.cb_cartao_credito);
//        cb_cartao_debito = findViewById(R.id.cb_cartao_debito);
//        cb_pix = findViewById(R.id.cb_pix);
//        cb_via_app = findViewById(R.id.cb_via_app);
        et_observacoes = findViewById(R.id.et_observacoes);
//
//
//        rb_cancelamento_sim = findViewById(R.id.rb_cancelamento_sim);
//        rb_cancelamento_nao = findViewById(R.id.rb_cancelamento_nao);
//        rb_taxa_unica = findViewById(R.id.rb_taxa_unica);
//        rb_personalizada = findViewById(R.id.rb_personalizada);
//        rb_abaixo_cem = findViewById(R.id.rb_abaixo_cem);
//        rb_acima_cem = findViewById(R.id.rb_acima_cem);
//
//        cb_domingo = findViewById(R.id.cb_domingo);
//        cb_segunda = findViewById(R.id.cb_segunda);
//        cb_terca = findViewById(R.id.cb_terca);
//        cb_quarta = findViewById(R.id.cb_quarta);
//        cb_quinta = findViewById(R.id.cb_quinta);
//        cb_sexta = findViewById(R.id.cb_sexta);
//        cb_sabado = findViewById(R.id.cb_sabado);



        //configurando router interface
//        routerInterface = APIUtil.getEmpresaInterface();

        //abrindo menu - NÃO DEU CERTO!!!
        menu_hambuguer.setOnClickListener(view -> {
            abrindoMenu();
        });

        //clique para ir para a próxima tela
        arrow_forward.setOnClickListener(view -> {
            int numeroContainerDestino = numeroContainerAtual+1;
            numeroContainerAtual = numeroContainerAtual+1;
            mostrarContainerDestino(numeroContainerDestino);
        });

        //clique para ir para a tela anterior
        arrow_back.setOnClickListener(view -> {
            int numeroContainerAnterior = numeroContainerAtual-1;
            numeroContainerAtual = numeroContainerAtual-1;
            mostrarContainerAnterior(numeroContainerAnterior);
        });

        adicionar_novo_conteiner_taxa_personalizada.setOnClickListener(view -> {
//            aparecendoNovoContainerPersonalizado();
            addNovoContainerPersonalizado();
        });


        //clique para cadastrar
        btn_cadastrar.setOnClickListener(view -> {
            ContaAdministradora contaAdministradora = new ContaAdministradora();

            //DADOS DA EMPRESA
                contaAdministradora.setId_empresa(id_empresa);
                contaAdministradora.setNome_fantasia(et_nome_do_negocio.getText().toString());
                contaAdministradora.setCnpj(et_cnpj.getText().toString());
                contaAdministradora.setTelefone(et_contato.getText().toString());
                //contaAdministradora.setImagem_perfil(iv_foto_perfil_estabelecimento.getText.toString);
                contaAdministradora.setBiografia(et_biografia.getText().toString());


            //PERFIL ADM
                contaAdministradora.setNome_adm(et_nome_do_adm.getText().toString());
                //DATA NASCIMENTO
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    contaAdministradora.setData_nascimento(LocalDate.parse(et_data_nascimento.getText().toString(), formatador));

                contaAdministradora.setCpf(et_cpf.getText().toString());
                contaAdministradora.setEmail_adm(et_email.getText().toString());
                contaAdministradora.setSenha_adm(et_senha.getText().toString());

            //DADOS DE LOCALIZAÇÃO
                contaAdministradora.setCep(et_cep.getText().toString());
                contaAdministradora.setBairro(et_bairro.getText().toString());
                contaAdministradora.setRua(et_rua.getText().toString());
                contaAdministradora.setNumero_rua(et_numero.getText().toString());
                contaAdministradora.setComplemento(et_complemento.getText().toString());
                contaAdministradora.setId_cidade(Integer.parseInt(id_cidade));

            //DADOS DE RECEBIMENTO
                //getFormasPagamento();
                contaAdministradora.setDados_formas_pagamento(getFormasPagamento());
                contaAdministradora.setObservacoes_pagamento(et_observacoes.getText().toString());


            //DADOS REGRAS DE NEGÓCIO
                //getTaxasCancelamento();
                if(rb_cancelamento_nao.isChecked() == true)
                {
                    contaAdministradora.setTaxa_unica_cancelamento(0);
                }
                else
                {
                    if(rb_taxa_unica.isChecked() == true)
                    {
                        int valor_taxa = Integer.parseInt(et_taxa_unica.getText().toString());
                        contaAdministradora.setTaxa_unica_cancelamento(valor_taxa);
                    }
                    else
                    {
                        contaAdministradora.setTaxa_unica_cancelamento(null);
                        contaAdministradora.setDados_taxa_cancelamento(getTaxasCancelamento());
                    }
                }

            //FUNCIONAMENTO
                if(rb_sim_intervalo_padrao_servicos.isChecked() == true)
                {
                    EditText et_minutos_intervalo = findViewById(R.id.et_minutos_intervalo);
                    int taxa = Integer.parseInt(et_minutos_intervalo.getText().toString());
                    contaAdministradora.setIntervalo_tempo_padrao_entre_servicos(taxa);

                    Log.d("teste_funcao_get_fucnionamento", "taxa:  "+ taxa);
                }
                else
                {
                    contaAdministradora.setIntervalo_tempo_padrao_entre_servicos(0);

                    Log.d("teste_funcao_get_fucnionamento", "taxa:  "+ 0);
                }

                contaAdministradora.setDados_funcionamento(getFuncionamento());

            ArrayList dadosFuncionamento = getFuncionamento();
                DiaUtil teste = (DiaUtil) dadosFuncionamento.get(0);
            Log.d("teste_funcao_get_fucnionamento", "onCreate: " + teste.getHora_inicio());
            //getFuncionamento();



            routerInterface = APIUtil.getEmpresaInterface();
            addContaAdministradora(contaAdministradora);
        });

        ;

        //Indo para a próxima intent
//            Intent homePrestador =
//                    new Intent(
//                            CadastroContaAdministradora.this,
//                            HomePrestador.class);




//        boolean opcaoSim = rb_cancelamento_sim.isChecked();

//        adicionar_novo_conteiner_taxa_personalizada.setOnClickListener(view -> {
////            if (click)
//        });




    }

    private ArrayList getFuncionamento()
    {
        int dia_da_semana_contador = 1;
        ArrayList<DiaUtil> arr_dados_funcionamento = new ArrayList();


        while (dia_da_semana_contador <=7)
        {
            String tag = "cb_dia_semana_"+ dia_da_semana_contador;
            CheckBox cb_dia_semana = linear_cb_dia_semana.findViewWithTag(tag);


            if (cb_dia_semana.isChecked() == true)
            {
                Log.d("teste_funcao_get_fucnionamento", "Tem horário pro dia: " + dia_da_semana_contador);

                String tag_linear_especifico = "linear_horarios_dia_" + dia_da_semana_contador;
                LinearLayout linear_horarios_dia = linear_horarios.findViewWithTag(tag_linear_especifico);

                EditText edit1_hora_incio = linear_horarios_dia.findViewWithTag("edit1_hora_inicio");
                EditText edit2_hora_incio = linear_horarios_dia.findViewWithTag("edit2_hora_inicio");
//                EditText edit2_hora_incio = linear_horarios_dia.findViewWithTag(R.id.edit2_hora_incio);

                if (edit1_hora_incio.getText().toString() != null && edit1_hora_incio.getText().toString() != "")
                {
                    EditText edit1_hora_termino = linear_horarios_dia.findViewWithTag("edit1_hora_termino");
                    DiaUtil diaUtil = new DiaUtil(
                            dia_da_semana_contador,
                            LocalTime.parse(edit1_hora_incio.getText().toString()),
                            LocalTime.parse(edit1_hora_termino.getText().toString())
                    );

                    Log.d("teste_funcao_get_fucnionamento", "Incio: " + edit1_hora_incio.getText().toString());
                    Log.d("teste_funcao_get_fucnionamento", "Termino: " + edit1_hora_termino.getText().toString());

                    arr_dados_funcionamento.add(diaUtil);
                }
//                if (edit2_hora_incio.getText().toString() != null && edit1_hora_incio.getText().toString() != "")
//                {
//                    EditText edit2_hora_termino = linear_horarios_dia.findViewWithTag("edit2_hora_termino");
//                    DiaUtil diaUtil = new DiaUtil(
//                            dia_da_semana_contador,
//                            LocalTime.parse(edit2_hora_incio.getText().toString()),
//                            LocalTime.parse(edit2_hora_termino.getText().toString())
//                    );
//
//                    arr_dados_funcionamento.add(diaUtil);
//                }
            }
            dia_da_semana_contador = dia_da_semana_contador+1;
        }


        return arr_dados_funcionamento;
    }

    private ArrayList getFormasPagamento()
    {
        int id_forma_pagamento = 1;
        ArrayList<Integer> arr_ids_formas_aceitas = new ArrayList<>();

        while (id_forma_pagamento < 6)
        {
            LinearLayout linear_formas_pagamento = findViewById(R.id.linear_formas_pagamento);
            String tag = "cb_forma_pagamento_" + id_forma_pagamento;
            Log.d("teste_funcao_get_formas_pagamento", "getFormasPagamento: " + tag);

            CheckBox cb_forma_pagamento = linear_formas_pagamento.findViewWithTag(tag);

            if (cb_forma_pagamento.isChecked()==true)
            {
                arr_ids_formas_aceitas.add(id_forma_pagamento);
            }

            id_forma_pagamento = id_forma_pagamento+1;
        }

        Log.d("teste_funcao_get_formas_pagamento", String.valueOf(arr_ids_formas_aceitas.size()));
        return arr_ids_formas_aceitas;
    }

    private ArrayList getTaxasCancelamento()
    {
        Log.d("teste_funcao_get_regas", "getRegrasNegocio: GETTTT");
        int quantidade_taxas = linear_taxa_personalizada.getChildCount();
        int contador = 1;
        int numero_regra = 1;
        ArrayList<RegraCancelamento> lista_regras_cancelamento = new ArrayList<>();

        while (contador <= quantidade_taxas)
        {
            String tag = "taxa_" +numero_regra;

            if (linear_taxa_personalizada.findViewWithTag(tag)!=null)
            {
                //Log.d("teste_funcao_get_regas", tag);

                //pegando o ccointainer da taxa
                LinearLayout taxa = linear_taxa_personalizada.findViewWithTag(tag);

                //pegando os campos do container da taxa
                RadioButton rb_acima_cem = (RadioButton) taxa.findViewById(R.id.rb_acima_cem);
                EditText et_tolerancia = (EditText) taxa.findViewById(R.id.et_valor_tolerancia);
                EditText et_taxa_valor_servico = (EditText) taxa.findViewById(R.id.et_taxa_valor_servico);

                //pegando os valores do campo
                int acima_cem = rb_acima_cem.isChecked() ? 1 : 0;
                int horas_tolerancia = Integer.parseInt(et_tolerancia.getText().toString());
                int porcentagem_cobrada = Integer.parseInt(et_taxa_valor_servico.getText().toString());

                // ------------- CRIACAO DO OBJETOO
                //devo criar uma classe RegraCancelamento e ir inserindo elas em uma lista?

                RegraCancelamento regraCancelamento = new RegraCancelamento();
                regraCancelamento.setAcima_cem(acima_cem);
                regraCancelamento.setHoras_tolerancia(horas_tolerancia);
                regraCancelamento.setPorcentagem_sobre_valor_servico(porcentagem_cobrada);

                Log.d("teste_funcao_get_regas", "acima de 100" + acima_cem);
                Log.d("teste_funcao_get_regas", "tempo tolerancia " + horas_tolerancia);
                Log.d("teste_funcao_get_regas", "taxa " + porcentagem_cobrada);

                lista_regras_cancelamento.add(regraCancelamento);
                contador = contador+1;
            }
            else
            {
                Log.d("teste_funcao_get_regas", "getRegrasNegocio: nAO ACHOU");

            }
            numero_regra = numero_regra+1;
        }
        Log.d("teste_funcao_get_regas", "quantidade de itens " + String.valueOf(lista_regras_cancelamento.size()));

        return lista_regras_cancelamento;
    }


    //FUNCAO PARA APARECER NOVO CONTAINER (TESTESS)
    private void addNovoContainerPersonalizado() {
//        Log.d("TESTE_BTN_ADD_TAXA", "addNovoContainerPersonalizado: clicado");

        View view_novo_card_taxa = LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_regra_negocio, null);

        String tag_taxa = "taxa_" + numero_regra_geral;
        view_novo_card_taxa.setTag(tag_taxa);

        linear_taxa_personalizada.addView(view_novo_card_taxa);

        numero_regra_geral = numero_regra_geral +1;
    }


        //TENTANDO ABRIR MENU
    public void abrindoMenu(){
        //clique para abrir menu
//        menu_hambuguer.setOnClickListener(view -> {
            if (menu_hambuguer.isSelected()){
                menu_hambuguer.setVisibility(View.VISIBLE);
            }
//        });
    }


    //VERIFICANDO QUAL DOS RADIOBUTTONS ESTÁ SELECIONADO
    public void verificandoRadioButton(View view){

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_cancelamento_sim:
                if (checked)
                    //show conteiner_radiobutton_sim
                    conteiner_radiobutton_sim.setVisibility(View.VISIBLE);
                    break;
            case R.id.rb_cancelamento_nao:
                if (checked)
                    // don't show conteiner_radiobutton_sim
                    conteiner_radiobutton_sim.setVisibility(View.INVISIBLE);
                    break;
            case R.id.rb_taxa_unica:
                if (checked)
                    et_taxa_unica.setVisibility(View.VISIBLE);
                    linear_taxa_personalizada.setVisibility(View.GONE);
                    adicionar_novo_conteiner_taxa_personalizada.setVisibility(View.GONE);
                    break;

            case R.id.rb_personalizada:
                if (checked) et_taxa_unica.setVisibility(View.GONE);
                linear_taxa_personalizada.setVisibility(View.VISIBLE);
                adicionar_novo_conteiner_taxa_personalizada.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_sim_intervalo_padrao_servicos:
                if (checked)
                    linear_intervalo_padrao.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_nao_intervalo_padrao_servicos:
                if (checked)
                    linear_intervalo_padrao.setVisibility(View.GONE);
        }

    }



    public void addContaAdministradora(ContaAdministradora contaAdministradora) {
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getNome_fantasia());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getCnpj());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getTelefone());
//        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getImagem_perfil());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getBiografia());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getNome_adm());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getData_nascimento().toString());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getCpf());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getCep());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getRua());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getNumero_rua());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getComplemento());
        Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(contaAdministradora.getId_cidade()));

        //FORMAS PAGAMENTO
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(contaAdministradora.getDados_formas_pagamento().size()));
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", "forma pagamento - " + String.valueOf(contaAdministradora.getDados_formas_pagamento().get(1)));
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getObservacoes_pagamento());

        //FUNCIONAMENTO
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(contaAdministradora.getDados_funcionamento().size()));
            DiaUtil teste = (DiaUtil) contaAdministradora.getDados_funcionamento().get(0);
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(teste.getId_dia_semana()));
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", teste.getHora_inicio().toString());
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", teste.getHora_termino().toString());

        //TAXAS CANCELAMENTO
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(contaAdministradora.getDados_taxa_cancelamento().size()));
            RegraCancelamento teste_taxas = (RegraCancelamento) contaAdministradora.getDados_taxa_cancelamento().get(0);
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(teste_taxas.getAcima_cem()));
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(teste_taxas.getHoras_tolerancia()));
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(teste_taxas.getPorcentagem_sobre_valor_servico()));
            //Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", String.valueOf(contaAdministradora.getTaxa_unica_cancelamento()));

        //LOGIN
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getEmail_adm());
            Log.d("DEBUG DADOS RECEBIDOS_ADD_CONTA_ADM", contaAdministradora.getSenha_adm());

        Call<ContaAdministradora> call = routerInterface.addEmpresa(contaAdministradora);

        //EXECUÇÃO DA CHAMADA DA ROTA - ENVIO DA REQ
        call.enqueue(
                new Callback<ContaAdministradora>() {
                    @Override
                    public void onResponse(Call<ContaAdministradora> call, Response<ContaAdministradora> response) {
                        if (response.isSuccessful()) //categoria 200
                        {
                            ContaAdministradora teste = response.body();

                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste);
                            Toast.makeText(CadastroContaAdministradora.this, "Empresa cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                            Log.d("DEBUG_ENVIO_DADOS", "Passou da categoria 200");

                            Log.d("DEBUG_ENVIO_DADOS", String.valueOf(response.raw()));

                        }
                        else
                        {
                            Toast.makeText(CadastroContaAdministradora.this, "OPS", Toast.LENGTH_SHORT).show();
                            String teste = response.message();
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste);

                            String teste1 = String.valueOf(response.raw());
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste1);

                            String teste2 = String.valueOf(response.errorBody());
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste2);

                        }
                    }

                    @Override
                    public void onFailure(Call<ContaAdministradora> call, Throwable t) {
                        Toast.makeText(CadastroContaAdministradora.this, "Erro ao cadastrar empresa", Toast.LENGTH_SHORT).show();
                        Log.d("ERRO_API=> ", t.getMessage());
                    }
                });
    }



    //IR PARA A PRÓXIMA TELA
    private void mostrarContainerDestino(int numeroContainerDestino ) {

        LinearLayout containerDestino = null;
        LinearLayout containerAtual = null;

        if(numeroContainerDestino == 2) {
            containerDestino = container2;
            containerAtual = container1;
            arrow_back.setVisibility(View.VISIBLE);
        }

        else if(numeroContainerDestino == 3) {
            containerDestino = container3;
            containerAtual = container2;
        }

        else if(numeroContainerDestino == 4) {
            containerDestino = container4;
            containerAtual = container3;
        }

        else if(numeroContainerDestino == 5) {
            containerDestino = container5;
            containerAtual = container4;
        }

        else if(numeroContainerDestino == 6) {
            containerDestino = container6;
            containerAtual = container5;
        }
        else if(numeroContainerDestino == 7) {
            containerDestino = container7;
            containerAtual = container6;
            arrow_forward.setVisibility(View.INVISIBLE);
        }

        else {
            containerAtual = container7;
//            containerDestino =

//            startActivity(HomePrestador);
//            btn_cadastrar.setOnClickListener(view -> {
//                Intent homePrestador =
//                        new Intent(
//                                CadastroContaAdministradora.this,
//                                HomePrestador.class);
//                    }

        }

        containerAtual.setVisibility(View.GONE);
        if (containerDestino != null)
        {
            containerDestino.setVisibility(View.VISIBLE);
        }
    }


    //VOLTAR PARA A "TELA" ANTERIOR
    private void mostrarContainerAnterior(int numeroContainerDestino) {
        LinearLayout containerDestino = null;
        LinearLayout containerAtual = null;

        if(numeroContainerDestino == 1) {
            containerDestino = container1;
            containerAtual = container2;
            arrow_back.setVisibility(View.INVISIBLE);
        }

        else if(numeroContainerDestino == 2) {
            containerDestino = container2;
            containerAtual = container3;
        }

        else if(numeroContainerDestino == 3) {
            containerDestino = container3;
            containerAtual = container4;
        }

        else if(numeroContainerDestino == 4) {
            containerDestino = container4;
            containerAtual = container5;
        }

        else if(numeroContainerDestino == 5) {
            containerDestino = container5;
            containerAtual = container6;
        }

        else if(numeroContainerDestino == 6) {
            containerDestino = container6;
            containerAtual = container7;
            arrow_forward.setVisibility(View.VISIBLE);
        }

        else {
            containerDestino = container7;
//            containerAtual = container1;

        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }

}


