package com.example.ornatis_tcc.UI.conta_administradora.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.DiaUtil;
import com.example.ornatis_tcc.model.Funcionarios;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.time.LocalTime;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorCadastrarFuncionario extends AppCompatActivity {

    RouterInterface routerInterface;
//    private EditText et_nome_do_funcionario;
//    private EditText et_login_acesso;
//    private EditText et_senha;
    private Button btn_cancelar;
    private Button btn_cadastrar;
    private LinearLayout linear_cb_dia_semana;
    private LinearLayout linear_horarios;

    ImageView iv_foto_perfil_funcionario;
    EditText et_nome_do_funcionario;
    EditText et_senha;


//    CheckBox cb_domingo;
//    CheckBox cb_segunda;
//    CheckBox cb_terca;
//    CheckBox cb_quarta;
//    CheckBox cb_quinta;
//    CheckBox cb_sexta;
//    CheckBox cb_sabado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastrar_funcionario);

        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        btn_cancelar = findViewById(R.id.btn_cancelar);
        linear_cb_dia_semana = findViewById(R.id.linear_cb_dia_semana);
        linear_horarios = findViewById(R.id.linear_horarios);

        //ATRELAMENTO DA REPRESENTAÇÃO COM O COMPONENETE GRÁFICO
//      IMAGEM  iv_foto_perfil_funcionario = findViewById(R.id.et_nome_do_funcionario);
        et_nome_do_funcionario = findViewById(R.id.et_nome_do_funcionario);
        et_senha = findViewById(R.id.et_senha);
//
//        //clique para cadastrar
        btn_cadastrar.setOnClickListener(view -> {

            Funcionarios funcionario = settarDadosFormularioFuncionario();

            //CHAMAR ROUTERINTERFACE
            routerInterface = APIUtil.getEmpresaInterface();
            addFuncionario(funcionario);


        });

            //clique para cancelar
//        btn_cancelar.setOnClickListener(view -> {

//        });

        //COLOCANDO A SETA DE VOLTAR NA PARTE SUPERIOR DA TELA
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);


    }    /**FIM DO ON CREATE **/

    private Funcionarios settarDadosFormularioFuncionario() {

        Funcionarios funcionario = new Funcionarios();

        //DADOS PESSOAIS
//        funcionario.setFoto_perfil(iv_foto_perfil_funcionario.toString);
        funcionario.setNome_funcionario(et_nome_do_funcionario.getText().toString());
        funcionario.setSenha(et_senha.getText().toString());

        funcionario.setAcao("createFuncionario");
        funcionario.setId_empresa(19);

        //DADOS DOS DIAS DE TRABALHO
        funcionario.setDados_funcionamento(getDiaDeTrabalho());
        ArrayList dadosDiaDeTrabalho = getDiaDeTrabalho();
        DiaUtil teste = (DiaUtil) dadosDiaDeTrabalho.get(0);
        Log.d("teste_funcao_get_fucnionamento", "onCreate: " + teste.getHora_inicio_localtime());

        return funcionario;
    }




    private ArrayList getDiaDeTrabalho(){

        int dia_da_semana_contador = 1;
        ArrayList<DiaUtil> arr_dados_dia_trabalho = new ArrayList();

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

                    arr_dados_dia_trabalho.add(diaUtil);
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

        return arr_dados_dia_trabalho;

    }


    public void addFuncionario(Funcionarios funcionarios){
        Call<Funcionarios> call = routerInterface.addFuncionario(funcionarios);

        call.enqueue(
                new Callback<Funcionarios>() {
                    @Override
                    public void onResponse(Call<Funcionarios> call, Response<Funcionarios> response) {
                        Toast.makeText(PrestadorCadastrarFuncionario.this,
                                "Funcionário cadastrado com sucesso",
                                Toast.LENGTH_SHORT).show();

                                if (response.isSuccessful()){

                                    Intent intentListagemFuncionario = new Intent(PrestadorCadastrarFuncionario.this, PrestadorListagemFuncionarios.class);
                                    startActivity(intentListagemFuncionario);
                                }

                    }

                    @Override
                    public void onFailure(Call<Funcionarios> call, Throwable t) {
                        Toast.makeText(PrestadorCadastrarFuncionario.this,
                                "Erro ao cadastrar o funcionário",
                                Toast.LENGTH_SHORT).show();
                        Log.d("Erro_api", t.getMessage());
                    }
                }
        );
    }





    //COLOCANDO A SETA DE VOLTAR NA PARTE SUPERIOR DA TELA
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}