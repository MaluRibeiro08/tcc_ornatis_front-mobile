package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

public class CadastroContaAdministradora extends AppCompatActivity {

    RouterInterface routerInterface;
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

    int numeroContainerAtual = 1;

    //estabelecimento
    EditText et_nome_do_negocio;
    EditText et_cnpj;
    EditText et_contato;
//  iv_dash_foto_perfil_estabelecimento
    EditText et_biografia;

    //adm
    EditText et_nome_do_adm;
    EditText et_data_nascimento;
    EditText et_cpf;
//  EditText iv_dash_foto_perfil;

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
    RadioButton rb_cancelamento_sim;
    RadioButton rb_cancelamento_nao;
    RadioButton rb_taxa_unica;
    RadioButton rb_personalizada;
    RadioButton rb_abaixo_cem;
    RadioButton rb_acima_cem;

    //funcionamento
    CheckBox cb_domingo;
    CheckBox cb_segunda;
    CheckBox cb_terca;
    CheckBox cb_quarta;
    CheckBox cb_quinta;
    CheckBox cb_sexta;
    CheckBox cb_sabado;

    //dados de login
    EditText et_email;
    EditText et_senha;
    EditText et_confirmar_senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_conta_administradora);

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

        cb_tipo_dinheiro = findViewById(R.id.cb_tipo_dinheiro);
        cb_cartao_credito = findViewById(R.id.cb_cartao_credito);
        cb_cartao_debito = findViewById(R.id.cb_cartao_debito);
        cb_pix = findViewById(R.id.cb_pix);
        cb_via_app = findViewById(R.id.cb_via_app);
        et_observacoes = findViewById(R.id.et_observacoes);


        rb_cancelamento_sim = findViewById(R.id.rb_cancelamento_sim);
        rb_cancelamento_nao = findViewById(R.id.rb_cancelamento_nao);
        rb_taxa_unica = findViewById(R.id.rb_taxa_unica);
        rb_personalizada = findViewById(R.id.rb_personalizada);
        rb_abaixo_cem = findViewById(R.id.rb_abaixo_cem);
        rb_acima_cem = findViewById(R.id.rb_acima_cem);

        cb_domingo = findViewById(R.id.cb_domingo);
        cb_segunda = findViewById(R.id.cb_segunda);
        cb_terca = findViewById(R.id.cb_terca);
        cb_quarta = findViewById(R.id.cb_quarta);
        cb_quinta = findViewById(R.id.cb_quinta);
        cb_sexta = findViewById(R.id.cb_sexta);
        cb_sabado = findViewById(R.id.cb_sabado);


        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);
        et_confirmar_senha = findViewById(R.id.et_confirmar_senha);


        routerInterface = APIUtil.getEmpresaInterface();

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

        //clique para cadastrar
        btn_cadastrar.setOnClickListener(view -> {
            ContaAdministradora contaAdministradora = new ContaAdministradora();
//            contaAdministradora()

            //Indo para a próxima intent
//            Intent homePrestador =
//                    new Intent(
//                            CadastroContaAdministradora.this,
//                            HomePrestador.class);

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
