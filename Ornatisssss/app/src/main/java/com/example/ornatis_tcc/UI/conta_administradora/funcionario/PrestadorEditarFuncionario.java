package com.example.ornatis_tcc.UI.conta_administradora.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

public class PrestadorEditarFuncionario extends AppCompatActivity {


    RouterInterface routerInterface;

    ImageView iv_foto_perfil_funcionario;
    EditText et_nome_do_funcionario;
    EditText et_login_acesso;
    EditText et_senha;

    Button btn_cancelar;
    Button btn_salvar_alteracoes;

    //O QUE FAZER COM OS CHECK BOX?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_editar_funcionario);

        iv_foto_perfil_funcionario = findViewById(R.id.iv_foto_perfil_funcionario);
        et_nome_do_funcionario = findViewById(R.id.et_nome_do_funcionario);
        et_login_acesso = findViewById(R.id.et_login_acesso);
        et_senha = findViewById(R.id.et_senha);

        btn_cancelar = findViewById(R.id.btn_cancelar);
        btn_salvar_alteracoes = findViewById(R.id.btn_salvar_alteracoes);


        //COD OU ID _FUNCIONARIO?
        int cod_funcionario = getIntent().getExtras().getInt("cod_duncionario");

        routerInterface = APIUtil.getEmpresaInterface();

//        Call<List<Funcionarios>> callGetFuncionarioId = routerInterface.getFuncionarioId();

    }
}