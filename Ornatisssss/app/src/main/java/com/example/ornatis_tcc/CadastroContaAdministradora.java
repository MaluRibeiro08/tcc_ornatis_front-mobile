package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroContaAdministradora extends AppCompatActivity {

    RouterInterface routerInterface;
    private ImageView menu_hambuguer;
    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;
    private LinearLayout container5;
    private LinearLayout container6;
    private LinearLayout container7;
    private TextView arrow_back;
    private TextView arrow_forward;
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
//    RadioButton rb_abaixo_cem;
//    RadioButton rb_acima_cem;

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

        menu_hambuguer = findViewById(R.id.menu_hambuguer);
        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);
        container4 = findViewById(R.id.container4);
        container5 = findViewById(R.id.container5);
        container6 = findViewById(R.id.container6);
        container7 = findViewById(R.id.container7);

        arrow_back = findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        radio_group_sim_ou_nao = findViewById(R.id.radio_group_sim_ou_nao);
        rb_cancelamento_sim = findViewById(R.id.rb_cancelamento_sim);
        rb_cancelamento_nao = findViewById(R.id.rb_cancelamento_nao);
        rb_taxa_unica = findViewById(R.id.rb_taxa_unica);
        rb_personalizada = findViewById(R.id.rb_personalizada);

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
//        et_observacoes = findViewById(R.id.et_observacoes);
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
        routerInterface = APIUtil.getEmpresaInterface();

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

            contaAdministradora.setNome_fantasia(et_nome_do_negocio.getText().toString());
            contaAdministradora.setCnpj(et_cnpj.getText().toString());
            contaAdministradora.setTelefone(et_contato.getText().toString());
//            contaAdministradora.setImagem_perfil(iv_foto_perfil_estabelecimento.getText.toString);
            contaAdministradora.setBiografia(et_biografia.getText().toString());

            contaAdministradora.setNome_adm(et_nome_do_adm.getText().toString());
            contaAdministradora.setData_nascimento((Date) et_data_nascimento.getText());
            contaAdministradora.setCpf(et_cpf.getText().toString());


            contaAdministradora.setCep(et_cep.getText().toString());
            contaAdministradora.setBairro(et_bairro.getText().toString());
            contaAdministradora.setRua(et_rua.getText().toString());
            contaAdministradora.setNumero(et_numero.getText().toString());
            contaAdministradora.setComplemento(et_complemento.getText().toString());
//          contaAdministradora.setId_cidade(et_cidade.getText().toString());
            contaAdministradora.setNome_adm(et_uf.getText().toString());


//            contaAdministradora.setDados_recebimento(cb_tipo_dinheiro.getText().toString());
//            contaAdministradora.setDados_recebimento(cb_cartao_credito.getText().toString());
//            contaAdministradora.setDados_recebimento(cb_cartao_debito.getText().toString());
//            contaAdministradora.setDados_recebimento(cb_pix.getText().toString());
//            contaAdministradora.setDados_recebimento(cb_via_app.getText().toString());
//            contaAdministradora.setDados_recebimento(et_observacoes.getText().toString());


            //DADOS RECEBIMENTO?
            //chamar função



            //FUNCIONAMENTO?
            //chamar função



            contaAdministradora.setEmail_adm(et_email.getText().toString());
            contaAdministradora.setSenha_adm(et_senha.getText().toString());

        });

//        addContaAdministradora(contaAdministradora);

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



    //FUNCAO PARA APARECER NOVO CONTAINER (TESTESS)
    private void addNovoContainerPersonalizado() {
//        if (rb_personalizada.isSelected()){
//            linear_taxa_personalizada.addView(linear_taxa_personalizada);

//        linear_taxa_personalizada.appendChild(novaRegra);

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
        }

    }



    public void addContaAdministradora(ContaAdministradora contaAdministradora) {
        Call<ContaAdministradora> call = routerInterface.addEmpresa(contaAdministradora);

        //EXECUÇÃO DA CHAMADA DA ROTA - ENVIO DA REQ
        call.enqueue(
                new Callback<ContaAdministradora>() {
                    @Override
                    public void onResponse(Call<ContaAdministradora> call, Response<ContaAdministradora> response) {
                        Toast.makeText(CadastroContaAdministradora.this, "Empresa cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ContaAdministradora> call, Throwable t) {
                        Toast.makeText(CadastroContaAdministradora.this, "Empresa ao cadastrar livro", Toast.LENGTH_SHORT).show();
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

        else {
            containerAtual = container6;
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
        containerDestino.setVisibility(View.VISIBLE);
    }


    //VOLTAR PARA A "TELA" ANTERIOR
    private void mostrarContainerAnterior(int numeroContainerDestino) {
        LinearLayout containerDestino = null;
        LinearLayout containerAtual = null;

        if(numeroContainerDestino == 1) {
            containerDestino = container1;
            containerAtual = container2;
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
        }

        else {
            containerDestino = container7;
//            containerAtual = container1;

        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }

}


