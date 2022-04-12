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

//    variavel divatual = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_configuracao_conta);

//        text_view_perfil_estabelecimento = findViewById(R.id.text_view_perfil_estabelecimento);
//        container_perfil_estabelecimento1 = findViewById(R.id.container_perfil_estabelecimento);
//        container_perfil_estabelecimento2 = findViewById(R.id.container_perfil_estabelecimento);
//        container_perfil_estabelecimento3 = findViewById(R.id.container_perfil_estabelecimento);

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
//
//clivouProximo (()=>{
//
//        mostrarDiv(divAtual+1)
//
//        }
//
//function mostrarDi(divPOndeQueremosIr)
//        {
//            container_perfil_estabelecimento${divPOndeQueremosIr}.setVisibility(View.TRUE);
//            container_perfil_estabelecimento${divAtual}.setVisibility(View.GONE);
//            divAtual = divPOndeQueremosIr
//        }


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
//        }



