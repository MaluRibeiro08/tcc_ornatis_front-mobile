package com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorConfiguracaoConta extends AppCompatActivity {

    private TextView tv_perfil_estabelecimento;
    private LinearLayout container_perfil_estabelecimento;

    private TextView tv_perfil_adm;
    private LinearLayout container_perfil_adm;

    private TextView tv_dados_localizacao;
    private LinearLayout container_dados_localizacao;

    private TextView tv_recebimento;
    private LinearLayout container_recebimento;

    private TextView tv_regras_negocio;
    private LinearLayout container_regras_negocio;

    private TextView tv_funcionamento;
    private LinearLayout container_funcionamento;

    private TextView tv_dados_login;
    private LinearLayout container_dados_login;


    RouterInterface routerInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_configuracao_conta);

        tv_perfil_estabelecimento = findViewById(R.id.tv_perfil_estabelecimento);
        container_perfil_estabelecimento = findViewById(R.id.container_perfil_estabelecimento);

        tv_perfil_adm = findViewById(R.id.tv_perfil_adm);
        container_perfil_adm = findViewById(R.id.container_perfil_adm);

        tv_dados_localizacao = findViewById(R.id.tv_dados_localizacao);
        container_dados_localizacao = findViewById(R.id.container_dados_localizacao);

        tv_recebimento = findViewById(R.id.tv_recebimento);
        container_recebimento = findViewById(R.id.container_recebimento);

        tv_regras_negocio = findViewById(R.id.tv_regras_negocio);
        container_regras_negocio = findViewById(R.id.container_regras_negocio);

        tv_funcionamento = findViewById(R.id.tv_funcionamento);
        container_funcionamento = findViewById(R.id.container_funcionamento);

        tv_dados_login = findViewById(R.id.tv_dados_login);
        container_dados_login = findViewById(R.id.container_dados_login);


        // quando clicar nos text views
        //aparecer os containers
        //fazer uma funcao para essa parte

        mostrarContainersDeDados();

        routerInterface = APIUtil.getEmpresaInterface();

//        retrofit2.Call<List<ContaAdministradora>> call = routerInterface.getContaAdministradora();
//
//        call.enqueue(new Callback<List<ContaAdministradora>>() {
//            @Override
//            public void onResponse(retrofit2.Call<List<ContaAdministradora>> call, Response<List<ContaAdministradora>> response) {
//
//                if (response.isSuccessful()){
//                    List<Item> itens = new ArrayList<>();
//
//                    /** RECEBE OS DADOS DA API  **/
//                    List<ContaAdministradora> list = new ArrayList<Livro>();
//                    list = response.body();
//
//
//                    for (int i = 0; i < list.size(); i++){
//                        itens.add(new Item(0, list.get(i)));
//                    }
//                    RecyclerView recyclerView = findViewById(R.id./..../);
//
//                    recyclerView.setAdapter(new LivroAdapter(itens));
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ContaAdministradora>> call, Throwable t) {
//
//            }
//        });



    }

    private void mostrarContainersDeDados(){

        tv_perfil_estabelecimento.setOnClickListener(view -> {

            if (container_perfil_estabelecimento.getVisibility() == View.VISIBLE) {
                container_perfil_estabelecimento.setVisibility(View.GONE);
            } else {
                container_perfil_estabelecimento.setVisibility(View.VISIBLE);
            }
        });

        tv_perfil_adm.setOnClickListener(view -> {

            if (container_perfil_adm.getVisibility() == View.VISIBLE) {
                container_perfil_adm.setVisibility(View.GONE);
            } else {
                container_perfil_adm.setVisibility(View.VISIBLE);
            }
        });

        tv_dados_localizacao.setOnClickListener(view -> {

             if (container_dados_localizacao.getVisibility() == View.VISIBLE) {
                 container_dados_localizacao.setVisibility(View.GONE);
             } else {
                 container_dados_localizacao.setVisibility(View.VISIBLE);
             }
        });


        tv_recebimento.setOnClickListener(view -> {

            if (container_recebimento.getVisibility() == View.VISIBLE) {
                container_recebimento.setVisibility(View.GONE);
            } else {
                container_recebimento.setVisibility(View.VISIBLE);
            }
        });


        tv_regras_negocio.setOnClickListener(view -> {

            if (container_regras_negocio.getVisibility() == View.VISIBLE) {
                container_regras_negocio.setVisibility(View.GONE);
            } else {
                container_regras_negocio.setVisibility(View.VISIBLE);
            }
        });

        tv_funcionamento.setOnClickListener(view -> {

            if (container_funcionamento.getVisibility() == View.VISIBLE) {
                container_funcionamento.setVisibility(View.GONE);
            } else {
                container_funcionamento.setVisibility(View.VISIBLE);
            }
        });

        tv_dados_login.setOnClickListener(view -> {

            if (container_dados_login.getVisibility() == View.VISIBLE) {
                container_dados_login.setVisibility(View.GONE);
            } else {
                container_dados_login.setVisibility(View.VISIBLE);
            }
        });



    }








//<EditText
//                android:id="@+id/et_data"
//                        android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:hint="Data de Nascimento"
//                        android:layout_marginStart="20dp"
//                        android:layout_marginEnd="20dp"
//                        android:textSize="20sp"
//                        android:layout_marginTop="10dp"
//                        android:focusable="false"
//                        android:maxLines="1"/>


//ABRINDO CALENDÁRIO TESTAR EM JAVA

//    //Criar um calendário
//    val calendario = Calendar.getInstance()
//
//    //Determinar os dados (dia, mês e ano) do calendário
//    val ano = calendario.get(Calendar.YEAR)
//    val mes = calendario.get(Calendar.MONTH)
//    val dia = calendario.get(Calendar.DAY_OF_MONTH)
//
//    //Abrir o componente DatePicker
//    val etDataNascimento = findViewById<EditText>(R.id.et_data)
//
//            etDataNascimento.setOnClickListener {
//        val dp = DatePickerDialog(this,
//        DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
//
//        var diaFinal = _dia
//        var mesFinal = _mes + 1
//
//        var mesString = "$mesFinal"
//        var diaString = "$diaFinal"
//
//        if(mesFinal < 10) {
//        mesString = "0$mesFinal"
//        }
//
//        if((diaFinal < 10)) {
//        diaString = "0$diaFinal"
//        }
//
//        Log.i("xpto", _dia.toString())
//        Log.i("xpto", _mes.toString())
//
//        etDataNascimento.setText("$diaString/$mesString/$_ano")
//        //poderia ser: (_dia + "/" + _mes + "/" + _ano)
//        //mas como isso é variável, pode colocar o $ antes
//        }, ano, mes, dia)
//
//        dp.show()
//
//        }
//
        }



