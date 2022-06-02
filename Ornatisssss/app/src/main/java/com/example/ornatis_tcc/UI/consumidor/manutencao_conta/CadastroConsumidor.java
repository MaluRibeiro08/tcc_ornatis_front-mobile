package com.example.ornatis_tcc.UI.consumidor.manutencao_conta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.consumidor.HomeConsumidor;
import com.example.ornatis_tcc.UI.conta_administradora.HomePrestador;
import com.example.ornatis_tcc.UI.conta_administradora.PrestadorVizualizacaoPerfil;
import com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta.CadastroContaAdministradora;
import com.example.ornatis_tcc.model.Consumidor;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroConsumidor extends AppCompatActivity {

    RouterInterface routerInterface;

    private TextView arrow_back;
    private TextView arrow_forward;

    private EditText et_nome_consumidor;
    private EditText et_data_nascimento_consumidor;
    private EditText et_cpf;
    private EditText et_telefone_consumidor;
    private EditText et_cep_consumidor;
    private EditText et_bairro_consumidor;
    private EditText et_rua_consumidor;
    private EditText et_numero_endereco_consumidor;
    private EditText et_complemento_consumidor;
    private EditText et_email_consumidor;
    private EditText et_senha_consumidor;
    private Button btn_cadastrar_consumidor;

    private Integer id_cor_cabelo = null;
    private Integer id_comprimento_cabelo = null;
    private Integer id_tipo_cabelo = null;

    private int id_genero = 0;


    private String id_cidade = "3510609";

    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;


    int numeroContainerAtual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consumidor);


        //NAVEGACAO
            container1 = findViewById(R.id.container_cadastro_consumidor1);
            container2 = findViewById(R.id.ccontainer_cadastro_consumidor2);
            container3 = findViewById(R.id.container_cadastro_consumidor3);
            container4 = findViewById(R.id.container_cadastro_consumidor4);

            arrow_back = findViewById(R.id.arrow_back);
            arrow_forward = findViewById(R.id.arrow_forward);

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

        //DADOS - CADASTRO

            et_nome_consumidor = findViewById(R.id.et_nome_consumidor);
            et_data_nascimento_consumidor = findViewById(R.id.et_data_nascimento_consumidor);
            et_cpf = findViewById(R.id.et_cpf_consumidor);
            et_telefone_consumidor = findViewById(R.id.et_telefone_consumidor);
            et_cep_consumidor = findViewById(R.id.et_cep_consumidor);
            et_bairro_consumidor = findViewById(R.id.et_bairro_consumidor);
            et_rua_consumidor = findViewById(R.id.et_rua_consumidor);
            et_numero_endereco_consumidor = findViewById(R.id.et_numero_endereco_consumidor);
            et_complemento_consumidor = findViewById(R.id.et_complemento_consumidor);
            et_email_consumidor = findViewById(R.id.et_email_consumidor);
            et_senha_consumidor = findViewById(R.id.et_senha_consumidor);
            btn_cadastrar_consumidor = findViewById(R.id.btn_cadastrar_consumidor);
            //createConsumidor

        btn_cadastrar_consumidor.setOnClickListener(view -> {

            Consumidor consumidor = getDadosFormularioCadastroConsumidor();

            routerInterface = APIUtil.getEmpresaInterface();
            addConsumidor(consumidor);
        });
    }

    private Consumidor getDadosFormularioCadastroConsumidor()
    {
        Consumidor consumidor = new Consumidor();

        consumidor.setAcao("createConsumidor");
        consumidor.setNome_consumidor(et_nome_consumidor.getText().toString());
        consumidor.setCpf_consumidor(et_cpf.getText().toString());
        consumidor.setTelefone_consumidor(et_telefone_consumidor.getText().toString());
        consumidor.setGenero_consumidor(this.id_genero); //id_genero é estabelecido com a funcao dos check
        consumidor.setEmail_consumidor(et_email_consumidor.getText().toString());
        consumidor.setSenha_consumidor(et_senha_consumidor.getText().toString());
        consumidor.setBairro_consumidor(et_bairro_consumidor.getText().toString());
        consumidor.setRua_consumidor(et_rua_consumidor.getText().toString());
        consumidor.setNumero_endereco_consumidor(et_numero_endereco_consumidor.getText().toString());
        consumidor.setCep_endereco_consumidor(et_cep_consumidor.getText().toString());
        consumidor.setComplemento_endereco_consumidor(et_complemento_consumidor.getText().toString());
        consumidor.setId_cidade(this.id_cidade);
        consumidor.setId_cor_cabelo(this.id_cor_cabelo);
        consumidor.setId_comprimento_cabelo(this.id_comprimento_cabelo);
        consumidor.setId_tipo_cabelo(this.id_tipo_cabelo);
        //DATA NASCIMENTO
            // passamos um localDate e o setter guarda essa data e também converte para string e guarda
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            consumidor.setData_nascimento_consumidor(LocalDate.parse(et_data_nascimento_consumidor.getText().toString(), formatador));


        return consumidor;
    }

    public void addConsumidor (Consumidor consumidor)
    {
        Log.d("CADASTRO_ADD-CONSUMIDOR", "Esse é o método add consumidor");
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getNome_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getData_nascimento_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getAcao()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getCpf_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getTelefone_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getId_cor_cabelo()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getId_tipo_cabelo()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getGenero_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getId_comprimento_cabelo()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getEmail_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getSenha_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getId_cidade()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getBairro_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getRua_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getNumero_endereco_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getCep_endereco_consumidor()));
        Log.d("CADASTRO_ADD-CONSUMIDOR", String.valueOf(consumidor.getComplemento_endereco_consumidor()));



        Call<Consumidor> call = routerInterface.addConsumidor(consumidor);
        call.enqueue(
                new Callback<Consumidor>() {
                    @Override
                    public void onResponse(Call<Consumidor> call, Response<Consumidor> response)
                    {
                        if (response.isSuccessful()) //categoria 200
                        {
                            Consumidor teste = response.body();

                            Log.d("DEBUG_ENVIO_DADOS", String.valueOf(response.raw()));
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste.getId_consumidor());

                            Toast.makeText(CadastroConsumidor.this, "Consumidor cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(CadastroConsumidor.this, HomeConsumidor.class);
                            intent.putExtra("id_consumidor", teste.getId_consumidor());
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(CadastroConsumidor.this, "OPS", Toast.LENGTH_SHORT).show();

                            String teste = response.message();
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste);

                            String teste1 = String.valueOf(response.raw());
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste1);

                            String teste2 = String.valueOf(response.errorBody());
                            Log.d("DEBUG_ENVIO_DADOS", "onResponse: " + teste2);

                        }
                    }

                    @Override
                    public void onFailure(Call<Consumidor> call, Throwable t)
                    {
                        Toast.makeText(CadastroConsumidor.this, "Erro ao cadastrar empresa", Toast.LENGTH_SHORT).show();
                        Log.d("DEBUG_ENVIO_DADOS=>ERRO-API ", t.getMessage());

                    }
                }
        );
    }

    public void verificandoRadioButton(View view){

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_infos_cabelo_sim:
                if (checked)
                    //show conteiner_radiobutton_sim
                    findViewById(R.id.sv_dados_cabelo).setVisibility(View.VISIBLE);
                break;

            case R.id.rb_infos_cabelo_nao:
                if (checked)
                    //show conteiner_radiobutton_sim
                    findViewById(R.id.sv_dados_cabelo).setVisibility(View.GONE);
                break;

            case R.id.comprimento0:
                if (checked)
                    this.id_comprimento_cabelo = null;
                break;

            case R.id.comprimento1:
                if (checked)
                    this.id_comprimento_cabelo = 1;
                break;

            case R.id.comprimento2:
                if (checked)
                    this.id_comprimento_cabelo = 2;
                break;

            case R.id.comprimento3:
                if (checked)
                    this.id_comprimento_cabelo = 3;
                break;

            case R.id.comprimento4:
                if (checked)
                    this.id_comprimento_cabelo = 4;
                break;

            case R.id.comprimento5:
                if (checked)
                    this.id_comprimento_cabelo = 5;
                break;
        }

    }

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
            arrow_forward.setVisibility(View.INVISIBLE);
        }

        else {
            containerAtual = container4;
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
            arrow_forward.setVisibility(View.VISIBLE);
        }

        else {
            containerDestino = container4;
//            containerAtual = container1;

        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }

    public void verificarRadioGenero(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_button_feminino:
                if (checked)
                    this.id_genero = 1;
                break;

            case R.id.radio_button_masculino:
                if (checked)
                    this.id_genero = 2;
                break;

            case R.id.radio_button_outro:
                if (checked)
                    this.id_genero = 3;
                break;

            case R.id.radio_button_prefiro_nao_informar:
                if (checked)
                    this.id_genero = 4;
                break;

        }
    }

    public void settarCorCabelo(View view) {
        LinearLayout ln_pai_cores_cabelos = findViewById(R.id.ln_pai_cores_cabelos);

        int contador_cor_cabelo = 0;

        while (contador_cor_cabelo < ln_pai_cores_cabelos.getChildCount())
        {
            ln_pai_cores_cabelos.getChildAt(contador_cor_cabelo).setBackgroundTintList(null);
            contador_cor_cabelo = contador_cor_cabelo+1;
        }

        view.setBackgroundTintList(this.getResources().getColorStateList(R.color.cinza_clarinho));

        switch(view.getId()) {
            case R.id.ln_cor_cabelo_preto:
                this.id_cor_cabelo = 1;
                break;

            case R.id.ln_cor_cabelo_loiro:
                this.id_cor_cabelo = 6;
                break;

            case R.id.ln_cor_cabelo_ruivo:
                this.id_cor_cabelo = 7;
                break;

            case R.id.ln_cor_cabelo_castanho:
                this.id_cor_cabelo = 8;
                break;

            case R.id.ln_cor_cabelo_grisalho:
                this.id_cor_cabelo = 9;
                break;

            case R.id.ln_cor_cabelo_colorido:
                this.id_cor_cabelo = 0;
                break;
        }
    }

    public void settarTipoCabelo(View view) {

        LinearLayout ln_pai_tipos_cabelo = findViewById(R.id.ln_pai_tipos_cabelo);

        int contador_tipo_cabelo = 0;

        while (contador_tipo_cabelo < ln_pai_tipos_cabelo.getChildCount())
        {
            ln_pai_tipos_cabelo.getChildAt(contador_tipo_cabelo).setBackgroundTintList(null);
            contador_tipo_cabelo = contador_tipo_cabelo+1;
        }

        view.setBackgroundTintList(this.getResources().getColorStateList(R.color.cinza_clarinho));

        switch(view.getId()) {
            case R.id.ln_tipo_cabelo_liso_1:
                this.id_tipo_cabelo = 1;
                break;

            case R.id.ln_tipo_cabelo_ondulado_2:
                this.id_tipo_cabelo = 2;
                break;

            case R.id.ln_tipo_cabelo_cacheado_3:
                this.id_cor_cabelo = 3;
                break;

            case R.id.ln_tipo_cabelo_crespo_4:
                this.id_cor_cabelo = 4;
                break;
        }

    }
}