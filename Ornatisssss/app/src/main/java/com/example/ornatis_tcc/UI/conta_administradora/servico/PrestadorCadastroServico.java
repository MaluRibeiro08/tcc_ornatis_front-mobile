package com.example.ornatis_tcc.UI.conta_administradora.servico;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.HomePrestador;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorCadastrarFuncionario;
import com.example.ornatis_tcc.UI.conta_administradora.funcionario.PrestadorListagemFuncionarios;
import com.example.ornatis_tcc.model.Especialidade;
import com.example.ornatis_tcc.model.Funcionario;
import com.example.ornatis_tcc.model.Genero;
import com.example.ornatis_tcc.model.PartesCorpo;
import com.example.ornatis_tcc.model.Servico;
import com.example.ornatis_tcc.model.TipoAtendimento;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.lang.reflect.Array;
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

    private ArrayList<Genero> arr_publico_alvo_final = new ArrayList<>();


    private int id_empresa =2;
    
    private int id_especialidade;
    private int id_parte_corpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_cadastrar_servico);

        routerInterface = APIUtil.getEmpresaInterface();

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
            publicoAlvo.add("Feminino");
            publicoAlvo.add("Masculino");
            publicoAlvo.add("Ambos");

            ArrayAdapter<String> adapterPublicoAlvo = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, publicoAlvo);
            adapterPublicoAlvo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_publico_alvo.setAdapter(adapterPublicoAlvo);

            spinner_publico_alvo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    ArrayList<Genero> arr_publico_alvo= new ArrayList<>();

                    if (spinner_publico_alvo.getSelectedItemPosition() == 0)
                    {
                        Genero feminino = new Genero();
                        feminino.setId_genero(1);
                        arr_publico_alvo.add(feminino);
                    }
                    else if (spinner_publico_alvo.getSelectedItemPosition() == 1)
                    {
                        Genero masculino = new Genero();
                        masculino.setId_genero(2);
                        arr_publico_alvo.add(masculino);
                    }
                    else if (spinner_publico_alvo.getSelectedItemPosition() == 2)
                    {
                        Genero feminino = new Genero();
                        feminino.setId_genero(1);

                        Genero masculino = new Genero();
                        masculino.setId_genero(2);

                        arr_publico_alvo.add(masculino);
                        arr_publico_alvo.add(feminino);
                    }
                    arr_publico_alvo_final = arr_publico_alvo;
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView)
                {

                }
            });


        //spinner categoria
            spinner_especialidade = findViewById(R.id.spinner_especialidade);
            Call<ArrayList<Especialidade>> callEspecialidades = routerInterface.getEspecialidades(id_empresa);
            callEspecialidades.enqueue
            (
                new Callback<ArrayList<Especialidade>>()
                {
                    @Override
                    public void onResponse(Call<ArrayList<Especialidade>> call, Response<ArrayList<Especialidade>> response)
                    {
                       if (response.isSuccessful())
                       {
                           ArrayList<Especialidade> list = response.body();

                           final List<String> especialidade = new ArrayList<String>();
                           ArrayList<Integer> arr_id_especialidade = new ArrayList<Integer>();
                           
                           int contador_especialidades = 0;

                           while (contador_especialidades < list.size())
                           {
                               especialidade.add(list.get(contador_especialidades).getNome_especialidade());
                               arr_id_especialidade.add(list.get(contador_especialidades).getId_especialidade());
                               
                               contador_especialidades = contador_especialidades+1;
                           }

                           ArrayAdapter<String> adapterEspecialidade = new ArrayAdapter<String>(PrestadorCadastroServico.this, R.layout.support_simple_spinner_dropdown_item, especialidade);
                           adapterEspecialidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           spinner_especialidade.setAdapter(adapterEspecialidade);
                           
                           spinner_especialidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                               @Override
                               public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                   
                                   for (int contador = 0; contador<arr_id_especialidade.size(); contador++)
                                   {
                                       Log.d("DEBUG_ESPECIALIDAE", "id_especialidade " + arr_id_especialidade.get(contador) );
                                       if (spinner_especialidade.getSelectedItemPosition()+1 == arr_id_especialidade.get(contador))
                                       {
                                           id_especialidade = arr_id_especialidade.get(contador);
                                           Log.d("DEBUG_ESPECIALIDAE", "id_especialidade_escolhida " + id_especialidade );
                                       }
                                   }
                               }

                               @Override
                               public void onNothingSelected(AdapterView<?> adapterView) {
                                   Toast.makeText(PrestadorCadastroServico.this, "Escolha uma especialidade", Toast.LENGTH_SHORT).show();
                               }
                           });
                       }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Especialidade>> call, Throwable t)
                    {
                        Log.d("LISTAGEM-ESPPECIALIDADES_ON-FAILURE  ", t.getMessage());
                    }
                }
            );






        //spinner parte do corpo
        spinner_parte_corpo = findViewById(R.id.spinner_parte_corpo);
        final List<String> parteCorpo = new ArrayList<String>();


        Call<ArrayList<PartesCorpo>> callPartesCorpo = routerInterface.getPartesCorpo(id_empresa);
        callPartesCorpo.enqueue
                (
                    new Callback<ArrayList<PartesCorpo>>()
                    {
                        @Override
                        public void onResponse(Call<ArrayList<PartesCorpo>> call, Response<ArrayList<PartesCorpo>> response)
                        {
                            if (response.isSuccessful())
                            {
                                ArrayList<PartesCorpo> list = response.body();

                                final List<String> partesCorpo = new ArrayList<String>();
                                ArrayList<Integer> arr_id_partesCorpo = new ArrayList<Integer>();

                                int contador_PartesCorpos = 0;

                                while (contador_PartesCorpos < list.size())
                                {
                                    partesCorpo.add(list.get(contador_PartesCorpos).getNome_parte_corpo());
                                    Log.d("DEBUG_LISTAGEM_PARTE_CORPO", "ID_PARTE CORPO " + list.get(contador_PartesCorpos).getId_parte_corpo());
                                    arr_id_partesCorpo.add(list.get(contador_PartesCorpos).getId_parte_corpo());

                                    contador_PartesCorpos = contador_PartesCorpos+1;
                                }

                                ArrayAdapter<String> adapterPartesCorpo = new ArrayAdapter<String>(PrestadorCadastroServico.this, R.layout.support_simple_spinner_dropdown_item, partesCorpo);
                                adapterPartesCorpo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spinner_parte_corpo.setAdapter(adapterPartesCorpo);

                                spinner_parte_corpo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        for (int contador = 0; contador<arr_id_partesCorpo.size(); contador++)
                                        {
                                            if (spinner_parte_corpo.getSelectedItemPosition()+1 == arr_id_partesCorpo.get(contador))
                                            {
                                                id_parte_corpo = arr_id_partesCorpo.get(contador);
                                                Log.d("DEBUG_LISTAGEM_PARTE_CORPO", "ID_PARTE CORPO " + arr_id_partesCorpo.get(contador));
                                                Log.d("DEBUG_LISTAGEM_PARTE_CORPO", "VALOR DA VARIÁVEL " + id_parte_corpo);
                                            }
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<PartesCorpo>> call, Throwable t)
                        {
                            Log.d("LISTAGEM-ESPPECIALIDADES_ON-FAILURE  ", t.getMessage());
                        }
                    }
                );

        ArrayAdapter<String> adapterParteCorpo = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, parteCorpo);
        adapterParteCorpo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_parte_corpo.setAdapter(adapterParteCorpo);


        //Listagem funcionário
        Call<ArrayList<Funcionario>> call = routerInterface.getFuncionarios(id_empresa);
        call.enqueue(new Callback<ArrayList<Funcionario>>() {
            @Override
            public void onResponse(Call<ArrayList<Funcionario>> call, Response<ArrayList<Funcionario>> response) {
//                            Log.d("listagem", "teste2222");

                if (response.isSuccessful()){
//                                 Log.d("listagem", "onResponse: chegou");
                    ArrayList<Funcionario> funcionarios = new ArrayList<>();

                    //RECEBE OS DADOS DA API
                    ArrayList<Funcionario> arrayList = new ArrayList<Funcionario>();
                    arrayList = response.body();

                    Log.d("listagem", String.valueOf(arrayList.size()));

                    for (int i = 0; i < arrayList.size(); i++){
                        funcionarios.add(arrayList.get(i));
                    }

                    RecyclerView recyclerViewCadastroServicos = findViewById(R.id.recyclerViewFuncionariosCadastroServico);
                    recyclerViewCadastroServicos.setAdapter(new FuncionarioAdapterCadastroServico(funcionarios));

                }

            }

            @Override
            public void onFailure(Call<ArrayList<Funcionario>> call, Throwable t) {
                Log.d("listagem", "onResponse: ops");
            }
        });





        //AÇÃO DE CLIQUE PARA CRIAR UM NOVO SERVIÇO
        btn_cadastrar_servico.setOnClickListener(view -> {
            Servico servico = setDadosFormularioServico();
            servico.setAcao("createServico");

            routerInterface = APIUtil.getEmpresaInterface();
            addServico(servico);
        });


        //AÇÃO DE CLIQUE PARA CANCELAR E VOLTAR PARA A PÁGINA ANTERIOR
        btn_cancelar_servico.setOnClickListener(view -> {

            Intent intent = new Intent(PrestadorCadastroServico.this, HomePrestador.class);
            startActivity(intent);
            finish();

        });

    } //fim do método onCreate


    /** ADAPTER - RECYCLERVIEW **/

    /////////// ADAPTER -> FAZ PARTE DA LISTAGEM
    private class FuncionarioAdapterCadastroServico extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        ArrayList<Funcionario> funcionarios;

        public FuncionarioAdapterCadastroServico(ArrayList<Funcionario> funcionarios) {
            this.funcionarios = funcionarios;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new FuncionarioAdapterCadastroServico.FuncionarioViewHolderCadastroServico(
                    LayoutInflater.from(
                            parent.getContext()).inflate(
                                    R.layout.item_lisatagem_funcionario_checkbox,
                                    parent,
                                    false
                    ));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            /** DADOS DE FUNCIONÁRIO **/

            Funcionario funcionario = (Funcionario) this.funcionarios.get(position);
            Log.d("listagem", funcionario.getNome_funcionario());
            ((FuncionarioAdapterCadastroServico.FuncionarioViewHolderCadastroServico) holder).setFuncionarioDados(funcionario);

        }

        @Override
        public int getItemCount() {
            return funcionarios.size();
        }


        /** CLASSE DE VIEWHOLDER DA RECYCLERVIEW **/
        class FuncionarioViewHolderCadastroServico extends RecyclerView.ViewHolder {

            private CheckBox listagem_fucnionarios;
            private int id_funcionario;


            public FuncionarioViewHolderCadastroServico(@NonNull View itemViewFuncionario) {
                super(itemViewFuncionario);

                listagem_fucnionarios = itemViewFuncionario.findViewById(R.id.listagem_fucnionarios);


            } //FIM DO CONSTRUTOR DA CLASSE FuncionarioViewHolder

//                itemFuncionario.setOnClickListener(view -> {

//                });

            public void setFuncionarioDados(Funcionario funcionario) {
                listagem_fucnionarios.setText(funcionario.getNome_funcionario());
                String tag_funcionario = String.valueOf(funcionario.getId_funcionario());
                listagem_fucnionarios.setTag(tag_funcionario);
                id_funcionario = funcionario.getId_funcionario();
            }

        } /** FIM DA CLASSE VIEWHOLDER **/

    }

    /** FIM DO ADAPTER -> RECYCLER VIEW **/



    private Servico setDadosFormularioServico() {

        Servico servico = new Servico();
        servico.setId_empresa(id_empresa);
        servico.setNome_servico(et_nome_do_servico.getText().toString());
        servico.setDetalhes(et_detalhes_servico.getText().toString());
        servico.setPreco(Float.parseFloat(et_preco_servico.getText().toString()));
        servico.setDesconto(Integer.parseInt(et_desconto_servico.getText().toString()));
        servico.setTempo_duracao(Integer.parseInt(et_tempo_duracao_servico.getText().toString()));
        servico.setIntervalo(Integer.parseInt(et_intervalo_entre_servicos.getText().toString()));
        servico.setId_especialidade(id_especialidade);
        servico.setId_parte_corpo(id_parte_corpo);
        servico.setAtivo_para_uso(1);
        servico.setFuncionarios(settarFuncionario());
        servico.setPublico_alvo(arr_publico_alvo_final);
        int contador_teste = 0;
        while (contador_teste < arr_publico_alvo_final.size())
        {
            Log.d("DEBUG_LISTAGEM_GENEROS", "id_genero: " + arr_publico_alvo_final.get(contador_teste).getId_genero());
            contador_teste = contador_teste+1;
        }
        servico.setTipos_atendimento(settarTiposAtendimento());

        return servico;
    }

    private ArrayList<Funcionario> settarFuncionario ()
    {
        ArrayList<Funcionario> arr_funcionarios = new ArrayList<>();

        RecyclerView recyclerViewFuncionariosCadastroServico;

        recyclerViewFuncionariosCadastroServico = findViewById(R.id.recyclerViewFuncionariosCadastroServico);

        int contador_funcionarios = 0;

        while (contador_funcionarios < recyclerViewFuncionariosCadastroServico.getChildCount())
        {
            LinearLayout ln_gerenciador_recycler = (LinearLayout) recyclerViewFuncionariosCadastroServico.getChildAt(contador_funcionarios);

            CheckBox cb_funcionario = (CheckBox)  ln_gerenciador_recycler.getChildAt(0);

            if (cb_funcionario.isChecked())
            {
                Funcionario funcionario_escolhido = new Funcionario();
                Log.d("DEBUG-TAG", "settarFuncionario: " + cb_funcionario.getTag());
                funcionario_escolhido.setId_funcionario(Integer.parseInt(cb_funcionario.getTag().toString()));
                arr_funcionarios.add(funcionario_escolhido);
            }
            contador_funcionarios = contador_funcionarios+1;
        }

        return arr_funcionarios;
    }

        private ArrayList<TipoAtendimento> settarTiposAtendimento ()
    {
        ArrayList<TipoAtendimento> arr_tipos_atendimento = new ArrayList<>();
        CheckBox cb_estabelecimento = findViewById(R.id.cb_estabelecimento);
        CheckBox cb_domicilio = findViewById(R.id.cb_domicilio);

        if (cb_domicilio.isChecked())
        {
            TipoAtendimento domicilio = new TipoAtendimento();
            domicilio.setId_tipo_atendimento(2);
            arr_tipos_atendimento.add(domicilio);
        }
        if (cb_estabelecimento.isChecked())
        {
            TipoAtendimento estabelecimento = new TipoAtendimento();
            estabelecimento.setId_tipo_atendimento(1);
            arr_tipos_atendimento.add(estabelecimento);
        }

        return arr_tipos_atendimento;
    }

    private void addServico(Servico servico) {
        Call<Servico> call = routerInterface.addServico(servico);

        call.enqueue(
                new Callback<Servico>() {
                    @Override
                    public void onResponse(Call<Servico> call, Response<Servico> response) {
                        if (response.isSuccessful())
                        {
                            Toast.makeText(PrestadorCadastroServico.this,
                                    "Serviço cadastrado com sucesso",
                                    Toast.LENGTH_SHORT).show();
                            Log.d("ADD_SERVICO", "onResponse: " + response.body());

                            Intent intent = new Intent(PrestadorCadastroServico.this, PrestadorListagemServicos.class);
                            startActivity(intent);
                            finish();
                        }

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
