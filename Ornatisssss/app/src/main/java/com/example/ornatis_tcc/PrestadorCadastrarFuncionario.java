package com.example.ornatis_tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ornatis_tcc.model.ContaAdministradora;
import com.example.ornatis_tcc.model.Funcionarios;
import com.example.ornatis_tcc.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorCadastrarFuncionario extends AppCompatActivity {

    RouterInterface routerInterface;
    private Button btn_cancelar;
    private Button btn_cadastrar;

    ImageView iv_foto_perfil_funcionario;
    EditText et_nome_do_funcionario;
    EditText et_login_acesso;
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

        //ATRELAMENTO DA REPRESENTAÇÃO COM O COMPONENETE GRÁFICO
//      IMAGEM  iv_foto_perfil_funcionario = findViewById(R.id.et_nome_do_funcionario);
        et_nome_do_funcionario = findViewById(R.id.et_nome_do_funcionario);
        et_login_acesso = findViewById(R.id.et_login_acesso);
        et_senha = findViewById(R.id.et_senha);
//
//        //clique para cadastrar
        btn_cadastrar.setOnClickListener(view -> {
            Funcionarios funcionarios = new Funcionarios();

//          funcionarios.setFoto_perfil(iv_foto_perfil_funcionario.toString);
            funcionarios.setNome_funcionario(et_nome_do_funcionario.getText().toString());
            funcionarios.setLogin(et_login_acesso.getText().toString());
            funcionarios.setSenha(et_senha.getText().toString());

            //dados de funcionamento ??


        });

        btn_cancelar.setOnClickListener(view -> {

        });

        //COLOCANDO A SETA DE VOLTAR NA PARTE SUPERIOR DA TELA
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    public void addFuncionario(Funcionarios funcionarios){
        Call<Funcionarios> call = routerInterface.addFuncionario(funcionarios);

        call.enqueue(
                new Callback<Funcionarios>() {
                    @Override
                    public void onResponse(Call<Funcionarios> call, Response<Funcionarios> response) {
                        Toast.makeText(PrestadorCadastrarFuncionario.this, "Funcionário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Funcionarios> call, Throwable t) {
                        Toast.makeText(PrestadorCadastrarFuncionario.this, "Erro ao cadastrar o funcionário", Toast.LENGTH_SHORT).show();
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