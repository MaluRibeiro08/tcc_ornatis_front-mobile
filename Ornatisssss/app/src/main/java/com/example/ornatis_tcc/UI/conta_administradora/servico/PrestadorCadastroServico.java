package com.example.ornatis_tcc.UI.conta_administradora.servico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.HomePrestador;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorCadastrarFuncionario;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorListagemFuncionarios;
import com.example.ornatis_tcc.model.Funcionario;
import com.example.ornatis_tcc.model.Servico;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorCadastroServico extends AppCompatActivity {


    RouterInterface routerInterface;

    private Button btn_cancelar_servico;
    private Button btn_cadastrar_servico;

    EditText et_nome_do_servico;
    EditText et_preco_servico;
    EditText et_desconto_servico;
    EditText et_tempo_duracao_servico;
    EditText et_detalhes_servico;
    //publico alvo
    //categoria
    //parte do corpo
    //lista de funcionario (check box)
    //local atendimento

    EditText et_intervalo_entre_servicos;
    ImageView iv_foto_perfil_estabelecimento;

    private Spinner spinner_publico_alvo;
    private Spinner spinner_especialidade;
    private Spinner spinner_parte_corpo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastrar_servico);

        btn_cadastrar_servico = findViewById(R.id.btn_cadastrar_servico);
        btn_cancelar_servico = findViewById(R.id.btn_cancelar_servico);

        et_nome_do_servico = findViewById(R.id.et_nome_do_servico);
        et_preco_servico = findViewById(R.id.et_preco_servico);
        et_desconto_servico = findViewById(R.id.et_desconto_servico);
        et_tempo_duracao_servico = findViewById(R.id.et_tempo_duracao_servico);
        et_detalhes_servico = findViewById(R.id.et_detalhes_servico);
        //
        et_intervalo_entre_servicos = findViewById(R.id.et_intervalo_entre_servicos);
        iv_foto_perfil_estabelecimento = findViewById(R.id.iv_foto_perfil_estabelecimento);


        //spinner público alvo
        spinner_publico_alvo = findViewById(R.id.spinner_publico_alvo);
        final List<String> publicoAlvo = new ArrayList<String>();
        publicoAlvo.add("Ambos");
        publicoAlvo.add("Feminino");
        publicoAlvo.add("Masculino");

        ArrayAdapter<String> adapterPublicoAlvo = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, publicoAlvo);
        adapterPublicoAlvo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_publico_alvo.setAdapter(adapterPublicoAlvo);


        //spinner categoria
        spinner_especialidade = findViewById(R.id.spinner_especialidade);
        final List<String> especialidade = new ArrayList<String>();
        especialidade.add("especialidade1");
        especialidade.add("especialidade2");
        especialidade.add("especialidade3");
        especialidade.add("especialidade4");

        ArrayAdapter<String> adapterEspecialidade = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, especialidade);
        adapterEspecialidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_especialidade.setAdapter(adapterEspecialidade);


        //spinner parte do corpo
        spinner_parte_corpo = findViewById(R.id.spinner_parte_corpo);
        final List<String> parteCorpo = new ArrayList<String>();
        parteCorpo.add("Rosto");
        parteCorpo.add("Olhos");
        parteCorpo.add("Sobrancelhas");
        parteCorpo.add("Boca");
        parteCorpo.add("Cabeça");
        parteCorpo.add("Pés");
        parteCorpo.add("Mãos");

        ArrayAdapter<String> adapterParteCorpo = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, parteCorpo);
        adapterParteCorpo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_parte_corpo.setAdapter(adapterParteCorpo);


        //AÇÃO DE CLIQUE PARA CRIAR UM NOVO SERVIÇO
        btn_cadastrar_servico.setOnClickListener(view -> {
            Servico servico = setDadosFormularioServico();

            routerInterface = APIUtil.getEmpresaInterface();
            addServico(servico);
        });


        //AÇÃO DE CLIQUE PARA CANCELAR E VOLTAR PARA A PÁGINA ANTERIOR
        btn_cancelar_servico.setOnClickListener(view -> {

            Intent intent = new Intent(PrestadorCadastroServico.this, HomePrestador.class);
            startActivity(intent);
            finish();

        });

    }

    private Servico setDadosFormularioServico() {

        Servico servico = new Servico();

        servico.setNome_servico(et_nome_do_servico.getText().toString());

        //preco
//        servico.setPreco();

        //desconto
//        servico.setDesconto();

        //tempo de duracao
//        servico.setTempo_duracao();
        
        //detalhes
        servico.setDetalhes(et_detalhes_servico.getText().toString());
        //publico alvo
        //especialidade
        //parte do corpo
        //lista de funcioanrio
        //local de atendimento
        //intervalo
        //imagem

        return servico;
    }

    private void addServico(Servico servico) {
        Call<Servico> call = routerInterface.addServico(servico);

        call.enqueue(
                new Callback<Servico>() {
                    @Override
                    public void onResponse(Call<Servico> call, Response<Servico> response) {
                        Toast.makeText(PrestadorCadastroServico.this,
                                "Serviço cadastrado com sucesso",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Servico> call, Throwable t) {
                        Toast.makeText(PrestadorCadastroServico.this,
                                "Erro ao cadastrar o serviço",
                                Toast.LENGTH_SHORT).show();
                        Log.d("Erro_api", t.getMessage());
                    }
                }
        );
    }
}
