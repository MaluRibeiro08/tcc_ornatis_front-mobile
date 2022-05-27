package com.example.ornatis_tcc.UI.consumidor.manutencao_conta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ornatis_tcc.R;

public class CadastroConsumidor extends AppCompatActivity {

    private TextView arrow_back;
    private TextView arrow_forward;

    private LinearLayout container1;
    private LinearLayout container2;
    private LinearLayout container3;
    private LinearLayout container4;


    int numeroContainerAtual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consumidor);

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
            arrow_forward.setVisibility(View.VISIBLE);
        }

        else {
            containerDestino = container4;
//            containerAtual = container1;

        }

        containerAtual.setVisibility(View.GONE);
        containerDestino.setVisibility(View.VISIBLE);
    }

}